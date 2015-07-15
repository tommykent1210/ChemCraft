<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class GenerateItems extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:items';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Generate ChemCraft Items.';

	/**
	 * Create a new command instance.
	 *
	 * @return void
	 */
	public function __construct()
	{
		parent::__construct();
	}

	/**
	 * Execute the console command.
	 *
	 * @return mixed
	 */
	public function fire()
	{
		//Instantiate GenHelper
		$GenHelper = new GenHelper();

		//Set the Google Drive access key
		$key = '1QTH9lcbZhGYVjq76S10LiFmDNtqj0YaTU3NVdeO-_Lc';

		//Verbosity
		$this->line("--[ Building Items: Started]--", 'yellow');
		$this->line("Getting spreadsheet from google...", 'yellow');
		$this->line("");

		//Get the array of Items from Google Drive
    	$arr = $GenHelper->google_spreadsheet_to_array($key);

    	//Get the Image Source option
    	$imagesource = $this->option('imagesource');

    	//Output the image Source
    	$this->line("Image Source: ".$imagesource, 'cyan');

    	//Setup empty Arrays
        $items = array();
        $langArray = array();
        
        //Get the element counts
        $elementCount = count($arr);
        $currentElementCount = 0;
        
        //Loop through the items
        foreach ($arr as $element) {
        	//Increment the item count
        	$currentElementCount += 1;
        	
        	//Tell the user what we're doing
        	$this->line("Found Item: ".$element["ID"]. "(".$currentElementCount."/".$elementCount.")",'yellow');
        	
        	//Check if the item is enabled
        	if($element["Enabled"]) {

        		//Tell the user it is
        		$this->line("Item (".$element["ID"]. ") is enabled. Continuing",'green');

        		//Start image stuff
        		//Set the default texture (the block name)
        		$textureFile = $element["BaseSprite"];

        		//Get the image from CDN/Local
        		$baseTexture = $GenHelper->getImage($textureFile, $imagesource);

        		//Set the output folder
        		$textureOutput = Config::get('gen.projectTextureDir')."items/".$element["ID"].".png";

        		//Does it have a custom texture function set?

        		switch (strtolower($element["SpriteType"])) {
        			case 'tint':

        				//Get the tint hex
        				$tinthex = $element["TintColour"];

        				//Get the tint alpha
	        			$tintalpha = $element["TintAlpha"];

	        			//Tell the user (for logging purposes)
	        			$this->line("Tinting: ".$textureFile.".png with: #".$tinthex."(".$tintalpha.")", 'magenta');

	        			//Actually do the tint!
	        			$GenHelper->tintImage($baseTexture, $textureOutput, $tinthex, $tintalpha);
        				break;
        			case 'hue':

        				//Get the hue amount
        				$hueAmount = intval($element["HueAmount"]);
        				
        				//Tell the user (for logging purposes)
        				$this->line("Altering hue: ".$textureFile.".png by: ".$hueAmount." degrees", 'magenta');

        				//Actually hue the image!
        				$GenHelper->hueImage($baseTexture, $textureOutput, $hueAmount);
        			
        				break;

        			case 'huedesat':

        				//Get the hue amount
        				$hueAmount = intval($element["HueAmount"]);

        				//Get the desaturation amount
        				$desatAmount = intval($element["DesaturationAmount"]);

        				//Tell the user (for logging purposes)
        				$this->line("Altering hue: ".$textureFile.".png by: ".$hueAmount." degrees then desaturating by ".$desatAmount."%", 'magenta');
        			
        				//Hue and desaturate the image
        				$GenHelper->hueImageDesat($baseTexture, $textureOutput, $hueAmount,$desatAmount);

        				break;
        			default:

        				//Tell the user (for logging purposes)
        				$this->line("Copying: ".$texture.".png to textures folder...", 'magenta');

        				if($baseTexture == Config::get('gen.spritesDirItems')."missing.png") {
		        			
		        			//if the texture couldn't be found, then it will be set to missing later
		        			$this->line("Cannot copy texture to textures folder (Reason: 'missing'). Using missing.png", 'red');
			        		
			        		//no need to actually copy any files
			        		
		        		} else {
		        			//Copy the sprite straight over
        					copy($GenHelper->getImage($textureFile, $imagesource), $textureOutput);
		        		}
        				
	        			
        				break;
        		}

        		//set the texture for the item class
        		if($baseTexture == Config::get('gen.spritesDirItems')."missing.png") {
        			//if the texture couldn't be found, then set it to missing
        			$texture = 'missing';

        			$this->line("Cannot copy texture to textures folder (Reason: 'missing'). Using missing.png", 'red');
	        		
        		} else {
        			//if not, set it to the element ID
        			$texture = $element['ID'];
        		}
        		
	        	//Add the item to the loader
	        	array_push($items, array('id' => $element["ID"], 'name' => $element["Name"], 'texture' => $texture, 'stacksize' => $element["MaxStack"]));

        		
        		//create the language string for this item
	        	$langitem = "item.ChemCraft_".$element["ID"].".name=".$element["Name"];

	        	//Tell the user
	        	$this->line("Created language string for ".$element["ID"],'yellow');

        		//add it to the language array
        		array_push($langArray, $langitem);


        	} else {

        		//Nevermind, the item is disabled
				$this->line("Item (".$element["ID"]. ") is disabled.",'red');
				continue;
        	}	
        	
        	//Blank line for readability in the console
        	$this->info("");
        }

        //Generate the Item Loader
		$this->line("Writing ItemLoader", 'yellow');

		//Generate the code
		$itemloader = View::make('templates.itemloader')->with(array(
			"items" => $items
			));

		//output the blockload.java
		file_put_contents(Config::get('gen.codeDir')."ItemLoader.java", $itemloader);
		
		//tell the user
		$this->info("Done: ItemLoader.java");
        $this->line("");

        //Write out the language file
    	$this->line("Writing Language Files", 'yellow');
    	file_put_contents(Config::get('gen.langDir')."items_en_US.lang", implode(PHP_EOL, $langArray).PHP_EOL);
        $this->info("Lang file: Written ".count($langArray). " strings");
        $this->line("");

        $this->line("--[Building Items: Complete]--", 'yellow');
	}

	/**
	 * Get the console command arguments.
	 *
	 * @return array
	 */
	protected function getArguments()
	{
		return array(
			
		);
	}

	/**
	 * Get the console command options.
	 *
	 * @return array
	 */
	protected function getOptions()
	{
		return array(
			array("imagesource", "isource", InputOption::VALUE_OPTIONAL, "Where would you like to source the images from? Valid options: cdn, local, url", "local"),
		
			array("url", "url", InputOption::VALUE_OPTIONAL, "If the image source is URL, tell us where to find it", Config::get("gen.cdnURL")),
		);
	}

	

}
