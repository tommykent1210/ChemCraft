<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class GenerateRecipes extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:recipes';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Generate ChemCraft Recipes.';

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
		$key = '1ucav38Dpisgag2wQ5ZgOy9lFPtj5eITdNUDXgs-_rTA';


		$this->line("--[Building Recipes: Started]--", 'yellow');
		$this->line("Getting spreadsheet from google...", 'yellow');
		$this->line("");

    	$arr = $GenHelper->google_spreadsheet_to_array($key);

        $items = array();
        $langArray = array();
        $smelting = array();
        $shapeless = array();
        
        $elementCount = count($arr);
        $currentElementCount = 0;
        //var_dump($arr);
        foreach ($arr as $element) {
        	$currentElementCount += 1;
        	//var_dump($element);
        	//exit;
        	# code...
        	$input = "";
        	if($element["SmeltingInput"]) { $input = $element["SmeltingInput"]."->"; }
        	$this->line("Found Recipe for: ".$input.$element["OutputItem"]." (".$currentElementCount."/".$elementCount.")",'yellow');
        	if($element["Enabled"]) {
        		$this->line("Recipe is enabled. Continuing.",'green');


        		switch ($element["Type"]) {
        			case 'Smelting':
        				$this->line("Recipe is of type: SMELTING",'yellow');

        				$inputType = $GenHelper->getItemBlockType($element["SmeltingInputType"]);
        				$outputType = $GenHelper->getItemBlockType($element["OutputItemType"]);
        				

        				$tArr = array(
        					"SmeltingInput" => $element["SmeltingInput"],
        					"SmeltingInputType" => $inputType,
        					"OutputItem" => $element["OutputItem"],
        					"OutputItemType" => $outputType,
        					"OutputAmount" => $element["OutputAmount"]
        					);

        				//var_dump($tArr);
        				array_push($smelting, $tArr);

        				break;
        			
        			default:
        				# code...
        				break;
        			case 'Shapeless':
                        //$this->line("Recipe is of type: SMELTING",'yellow');
        				//var_dump($element);

                        $itemArr = array();
                        if($element["Item_A"] && $GenHelper->getItemBlockType($element["ItemType_A"])) { array_push($itemArr, $GenHelper->getItemStack($GenHelper->getItemBlockType(ucfirst($element["ItemType_A"])).".".$element["Item_A"], 1));}
                        if($element["Item_B"] && $GenHelper->getItemBlockType($element["ItemType_B"])) { array_push($itemArr, $GenHelper->getItemStack($GenHelper->getItemBlockType(ucfirst($element["ItemType_B"])).".".$element["Item_B"], 1));}
                        if($element["Item_C"] && $GenHelper->getItemBlockType($element["ItemType_C"])) { array_push($itemArr, $GenHelper->getItemStack($GenHelper->getItemBlockType(ucfirst($element["ItemType_C"])).".".$element["Item_C"], 1));}
                        if($element["Item_D"] && $GenHelper->getItemBlockType($element["ItemType_D"])) { array_push($itemArr, $GenHelper->getItemStack($GenHelper->getItemBlockType(ucfirst($element["ItemType_D"])).".".$element["Item_D"], 1));}
                        if($element["Item_E"] && $GenHelper->getItemBlockType($element["ItemType_E"])) { array_push($itemArr, $GenHelper->getItemStack($GenHelper->getItemBlockType(ucfirst($element["ItemType_E"])).".".$element["Item_E"], 1));}

                        $tArr = array(
                            "OutputItem" => $element["OutputItem"],
                            "OutputItemType" => $GenHelper->getItemBlockType($element["OutputItemType"]),
                            "OutputAmount" => $element["OutputAmount"],
                            "Items" => $itemArr,
                            );
                        //var_dump($tArr);

                        array_push($shapeless, $tArr);

                        break;
                    
                    default:
                        # code...
                        break;
                }


                

            } else {
                $this->line("Recipe is disabled. Skipping.",'red');
                continue;
            }   
                
            $this->info("");
        }

        //generate the item script
        //make the blockloader
        $this->line("Writing RecipeManager", 'yellow');
        //generate the code
        $itemloader = View::make('templates.recipemanager')->with(array(
            "smelting" => $smelting,
            "shapeless" => $shapeless
            ));

		//output the blockload.java
		file_put_contents(Config::get('gen.codeDir')."RecipeManager.java", $itemloader);
		
		//tell the user
		$this->info("Done: RecipeManager.java");
        $this->line("");

        $this->line("--[Building Recipes: Complete]--", 'yellow');
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
