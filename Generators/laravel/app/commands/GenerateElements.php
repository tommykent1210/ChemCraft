<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class GenerateElements extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:elements';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Generate ChemCraft Elements.';

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
		//Get the GenHelper instance
		$GenHelper = new GenHelper();

		//Set the Google Drive key
		$key = '1erWA95MmGF30nQcCpx4h89Z5kxwmbjFv04JSM5nCsoU';
		
		//Set the radioactive range
		$radioactiveRange = 5;

		//Tell the user we're starting
		$this->line("--[ Building Elements: Started]--", 'yellow');
		$this->line("Getting spreadsheet from google...", 'yellow');
		$this->line("");

		//Get the data from Google Drive
    	$arr = $GenHelper->google_spreadsheet_to_array($key);

    	//Get the Image Source option
    	$imagesource = $this->option('imagesource');

    	//Output the image Source
    	$this->line("Image Source: ".$imagesource, 'cyan');

    	//Setup the empty block, overworld blocks, and language array
        $blocks = array();
        $langArray = array();
        $overworldGenBlocks = array();

        //Setup element counters
        $elementCount = count($arr);
        $currentElementCount = 0;

        //Loop through the elements
        foreach ($arr as $element) {

        	//Increment the counter
        	$currentElementCount += 1;
        	 
        	//Tell the user
        	$this->line("Found Element: ".$element["ID"]. "(".$currentElementCount."/".$elementCount.")",'yellow');
        		
        	//Check if its an Ore or a Mineral (Or not found in nature)
        	if ($element['GenerateOre'] == "TRUE") {

        		//Tell the user the element will be generated
        		$this->info("Element is set to GENERATE");
        		
        		//its an ore
        		if(strtolower($element['Type']) == "ore" || strtolower($element['Type']) == "mineral") {

        			//Tell the user the type
        			$this->info("Element is of type ".strtoupper($element["Type"]).".");

	        		$texture = "";
	        		//Set the default texture (the block name)
	        		$textureFile = $element["ID"];

	        		//Does it have a custom texture set?
	        		if ($element["Texture"]) { $textureFile = $element["Texture"]; }

	        		//Get the image from CDN/Local
	        		$baseTexture = $GenHelper->getBlockImage($textureFile, $imagesource);

	        		//Set the output folder
	        		$textureOutput = Config::get('gen.projectTextureDir')."blocks/".$element["ID"].".png";

	        		//Is the texture missing?
	        		if ($baseTexture != Config::get('gen.spritesDirBlocks')."missing.png") {

	        			//Set the texture for minecraft
	        			$texture = $textureFile;

	        			//Copy the file over
	        			copy($baseTexture, $textureOutput);

	        			//Tell the user
	        			$this->line("Copying: ".$texture.".png to textures folder...", 'magenta');

	        		} else {

	        			//Nope! So set it as the "missing.png" image
	        			$texture = "missing";

	        			//Tell the user
	        			$this->line("Cannot copy: ".$textureFile.".png to textures folder (Reason: 'missing'). Using missing.png", 'red');
	        		}

	        		//add the block to the blocklist
	        		array_push($blocks, array("OreID" => $element["ID"],
	        			"OreName" => $element["OreName"],
	        			"OreTexture" => $texture,
	        			"ToolClass" => $element["ToolClass"],
	        			"ToolTier" => $element["ToolTier"],
	        			"Hardness" => $element["Hardness"],
	        			"Radioactive" => $element["Radioactive"],
	        			));

	        		//create the language string for this element
	        		$langitem = "tile.ChemCraft_".$element["ID"].".name=".$element["OreName"];
	        		
	        		//add it to the language array
	        		array_push($langArray, $langitem);

	        		//Tell the user the block is radioactive, this will instantiate GenericBlockRadioactive instead of GenericBlock
	        		if($element["Radioactive"] == "TRUE") {
	        			$this->line("Block is radioactive. Adding appropriate code.", 'magenta');
	
	        		}

	        		
        		} else {

        			//tell the user we're skipping this block because of the type
        			$this->line("Skipping: ".$element["Name"].". (Reason: 'Wrong Type')",'red');
        			$this->info("");
        			continue;
        		}
        	} else {

        		//tell the user we're skipping the block because we don't need it
        		$this->line("Skipping: ".$element["Name"].". (Reason: 'Don't Generate Ore')",'red');
        		$this->info("");
        		continue;
        	}
        	
        	//newline for readability in the console
        	$this->info("");
        }

    	//make the blockloader
		$this->line("Writing Blockloader", 'yellow');

		//generate the code
		$blockloader = View::make('templates.blockloader')->with(array(
			"blocks" => $blocks
			));

		//output the blockload.java
		file_put_contents(Config::get('gen.codeDir')."BlockLoader.java", $blockloader);
		
		//tell the user
		$this->info("Done: Blockloader.java");
        $this->line("");

    	//make the world generator
		$this->line("Writing BlockGenerator", 'yellow');
		//generate the code
		$worldGenerator = View::make('templates.worldgenerator')->with(array(
			"overworld" => $overworldGenBlocks
			));

		//output the world generation
		file_put_contents(Config::get('gen.codeDir')."BlockGeneration.java", $worldGenerator);
		
		//tell the user
		$this->info("Done: BlockGenerator.java");
        $this->line("");


    	//write out the lang file
    	$this->line("Writing Language Files", 'yellow');
    	file_put_contents(Config::get('gen.langDir')."blocks_en_US.lang", implode(PHP_EOL, $langArray).PHP_EOL);
        $this->info("Lang file: Written ".count($langArray). " strings");
        $this->line("");

        $this->line("--[Building Elements: Complete]--", 'yellow');
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
