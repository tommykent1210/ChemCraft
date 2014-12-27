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
		//
		$GenHelper = new GenHelper();
		$key = '1erWA95MmGF30nQcCpx4h89Z5kxwmbjFv04JSM5nCsoU';
		$radioactiveRange = 5;


		$this->line("--[ Building Elements: Started]--", 'yellow');
		$this->line("Getting spreadsheet from google...", 'yellow');
		$this->line("");

    	$arr = $GenHelper->google_spreadsheet_to_array($key);

        $blocks = array();
        $langArray = array();
        $overworldGenBlocks = array();

        $elementCount = count($arr);
        $currentElementCount = 0;
        //var_dump($arr);
        foreach ($arr as $element) {
        	$currentElementCount += 1;
        	//var_dump($element);
        	//exit;
        	# code...
        	$this->line("Found Element: ".$element["ID"]. "(".$currentElementCount."/".$elementCount.")",'yellow');
        		
        	//Check if its an Ore or a Mineral (Or not found in nature)
        	if ($element['GenerateOre'] == "TRUE") {
        		$this->info("Element is set to GENERATE");
        		
        		//its an ore
        		if($element['Type'] == "ore" || $element['Type'] == "Mineral") {

        			$this->info("Element is of type ".strtoupper($element["Type"]).".");
	        		$texture = "";
	        		//Set the default texture (the block name)
	        		$textureFile = $element["ID"];

	        		//Does it have a custom texture set?
	        		if ($element["Texture"]) { $textureFile = $element["Texture"]; }

	        		//Does the texture even exist?
	        		if (file_exists(Config::get('gen.spritesDir')."Blocks/".$textureFile.".png")) {
	        			$texture = $textureFile;
	        			//copy the file to the project directory

	        			//echo Config::get('gen.spritesDir').$textureFile.".png"; 
	        			//echo Config::get('gen.projectTextureDir')."blocks/".$textureFile.".png";

	        			copy(Config::get('gen.spritesDir')."Blocks/".$textureFile.".png", Config::get('gen.projectTextureDir')."blocks/".$textureFile.".png");
	        			$this->line("Copying: ".$texture.".png to textures folder...", 'magenta');
	        		} else {
	        			//Nope! So set it as the "missing.png" image
	        			$texture = "missing";
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

	        		if($element["Radioactive"] == "TRUE") {
	        			$this->line("Block is radioactive. Adding appropriate code.", 'magenta');
	
	        		}

	        		/*//output the java file for the block
	        		$content = View::make('templates.block')->with(array(
	        			"OreID" => $element["ID"],
	        			"OreName" => $element["OreName"],
	        			"OreTexture" => $texture,
	        			"ToolClass" => $element["ToolClass"],
	        			"ToolTier" => $element["ToolTier"],
	        			"Hardness" => $element["Hardness"],
	        			"Radioactive" => $element["Radioactive"],
	        			"RadioactiveRange" => $radioactiveRange
	        			));

					//add to worldgen stuff
					$tempWorldGenArr = array(
						"ID" => $element['ID'],
						"SpawnChance" => $element['SpawnChance'],
						"MinVeinSize" => $element['MinVeinSize'],
						"MaxVeinSize" => $element['MaxVeinSize'],
						"MinSpawnHeight" => $element['MinSpawnHeight'],
						"MaxSpawnHeight" => $element['MaxSpawnHeight']
						);
					array_push($overworldGenBlocks, $tempWorldGenArr);

	        		//save the block class out for this block
	        		file_put_contents(Config::get('gen.codeDir')."Blocks/".$element['ID'].".java", $content);

					
	        		//Tell them we're done
	        		$this->info("Written Element: ".$element["Name"].".java (Type: '".$element["Type"].$element["GenerateOre"]."')");
        		
					*/
        		} else {
        			$this->line("Skipping: ".$element["Name"].". (Reason: 'Wrong Type')",'red');
        			$this->info("");
        			continue;
        		}
        	} else {
        		$this->line("Skipping: ".$element["Name"].". (Reason: 'Don't Generate Ore')",'red');
        		$this->info("");
        		continue;
        	}
        	
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

		//output the blockload.java
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
			
		);
	}

}
