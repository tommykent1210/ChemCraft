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
		//
		$GenHelper = new GenHelper();
		$key = '1QTH9lcbZhGYVjq76S10LiFmDNtqj0YaTU3NVdeO-_Lc';


		$this->line("--[ Building Items: Started]--", 'yellow');
		$this->line("Getting spreadsheet from google...", 'yellow');
		$this->line("");

    	$arr = $GenHelper->google_spreadsheet_to_array($key);

        $items = array();
        $langArray = array();
        
        $elementCount = count($arr);
        $currentElementCount = 0;
        //var_dump($arr);
        foreach ($arr as $element) {
        	$currentElementCount += 1;
        	//var_dump($element);
        	//exit;
        	# code...
        	$this->line("Found Item: ".$element["ID"]. "(".$currentElementCount."/".$elementCount.")",'yellow');
        	if($element["Enabled"]) {
        		$this->line("Item (".$element["ID"]. ") is enabled. Continuing",'green');

        		//add the item to the loader


        		//do image stuff
        		$texture = "";
        		//Set the default texture (the block name)
        		$textureFile = $element["BaseSprite"];

        		//Does it have a custom texture set?
        		if ($element["SpriteType"] == "Tint") { 

        			$baseTexture = Config::get('gen.spritesDirItems').$textureFile.".png";
        			$copyLocation = Config::get('gen.projectTextureDir')."Items/".$element["ID"].".png";
        			$tinthex = $element["TintColour"];
        			$tintalpha = $element["TintAlpha"];
        			$this->line("Tinting: ".$textureFile.".png with: #".$tinthex."(".$tintalpha.")", 'magenta');
        			$GenHelper->tintImage($baseTexture, $copyLocation, $tinthex, $tintalpha);
        			$texture = $element["ID"];
        		} elseif ($element["SpriteType"] == "Hue") {
        			$baseTexture = Config::get('gen.spritesDirItems').$textureFile.".png";
        			$copyLocation = Config::get('gen.projectTextureDir')."Items/".$element["ID"].".png";
        			$hueAmount = intval($element["HueAmount"]);
        			$this->line("Altering hue: ".$textureFile.".png by: ".$hueAmount." degrees", 'magenta');
        			$GenHelper->hueImage($baseTexture, $copyLocation, $hueAmount);
        			$texture = $element["ID"];
        		} elseif ($element["SpriteType"] == "HueDesat") {
        			$baseTexture = Config::get('gen.spritesDirItems').$textureFile.".png";
        			$copyLocation = Config::get('gen.projectTextureDir')."Items/".$element["ID"].".png";
        			$hueAmount = intval($element["HueAmount"]);
        			$desatAmount = intval($element["DesaturationAmount"]);
        			$this->line("Altering hue: ".$textureFile.".png by: ".$hueAmount." degrees then desaturating by ".$desatAmount."%", 'magenta');
        			$GenHelper->hueImageDesat($baseTexture, $copyLocation, $hueAmount,$desatAmount);
        			$texture = $element["ID"];
        		} else {	
        		//Does the texture even exist?
	        		if (file_exists(Config::get('gen.spritesDirItems').$textureFile.".png")) {
	        			$texture = $textureFile;
	        			//copy the file to the project directory

	        			copy(Config::get('gen.spritesDirItems').$textureFile.".png", Config::get('gen.projectTextureDir')."Items/".$textureFile.".png");
	        			$this->line("Copying: ".$texture.".png to textures folder...", 'magenta');
	        		} else {
	        			//Nope! So set it as the "missing.png" image
	        			$texture = "missing";
	        			$this->line("Cannot copy: ".$textureFile.".png to textures folder (Reason: 'missing'). Using missing.png", 'red');
	        		}
	        	}
        	
        		//generate the item class
        		/*$content = View::make('templates.item')->with(array(
	        			"id" => $element["ID"],
	        			"name" => $element["Name"],
	        			"texture" => $texture
	        			
	        			));

        		//save the block class out for this block
        		$this->line("Saving Class for ".$element["ID"]. " to ".$element["ID"].".java",'yellow');

        		file_put_contents(Config::get('gen.codeDir')."items/".$element['ID'].".java", $content);
				*/

	        	//add the item to the laoder
	        	array_push($items, array('id' => $element["ID"], 'name' => $element["Name"], 'texture' => $texture, 'stacksize' => $element["MaxStack"]));

        		
        		//create the language string for this item
	        	$langitem = "item.ChemCraft_".$element["ID"].".name=".$element["Name"];
	        	$this->line("Created language string for ".$element["ID"],'yellow');

        		//add it to the language array
        		array_push($langArray, $langitem);


        	} else {
				$this->line("Item (".$element["ID"]. ") is disabled.",'red');
				continue;
        	}	
        		
        	$this->info("");
        }

        //generate the item script
		//make the blockloader
		$this->line("Writing ItemLoader", 'yellow');
		//generate the code
		$itemloader = View::make('templates.itemloader')->with(array(
			"items" => $items
			));

		//output the blockload.java
		file_put_contents(Config::get('gen.codeDir')."ItemLoader.java", $itemloader);
		
		//tell the user
		$this->info("Done: ItemLoader.java");
        $this->line("");

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
			
		);
	}

}
