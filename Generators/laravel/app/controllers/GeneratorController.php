<?php

class GeneratorController extends BaseController {


	public function getIndex()
    {
        //
        echo "Generator Controller";
    }

    public function getElements()
    {
        $GenHelper = new GenHelper();
        $key = '1ucav38Dpisgag2wQ5ZgOy9lFPtj5eITdNUDXgs-_rTA';


        //$this->line("--[Building Recipes: Started]--", 'yellow');
        //$this->line("Getting spreadsheet from google...", 'yellow');
        //$this->line("");

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

            //$this->line("Found Recipe for: ".$element["OutputItem"]." (".$currentElementCount."/".$elementCount.")",'yellow');
            if($element["Enabled"]) {
                //$this->line("Recipe is enabled. Continuing.",'green');

                switch ($element["Type"]) {
                    case 'Smelting':
                        //$this->line("Recipe is of type: SMELTING",'yellow');

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
                    case 'Shapeless':
                        //$this->line("Recipe is of type: SMELTING",'yellow');
                        $itemArr = array();
                        if($element["Item_A"] && $element["ItemType_A"]) { array_push($itemArr, "new ItemStack(".ucfirst($element["ItemType_A"])."Loader.".$element["Item_A"].", 1)");}
                        if($element["Item_B"] && $element["ItemType_B"]) { array_push($itemArr, "new ItemStack(".ucfirst($element["ItemType_B"])."Loader.".$element["Item_B"].", 1)");}
                        if($element["Item_C"] && $element["ItemType_C"]) { array_push($itemArr, "new ItemStack(".ucfirst($element["ItemType_C"])."Loader.".$element["Item_C"].", 1)");}
                        if($element["Item_D"] && $element["ItemType_D"]) { array_push($itemArr, "new ItemStack(".ucfirst($element["ItemType_D"])."Loader.".$element["Item_D"].", 1)");}
                        if($element["Item_E"] && $element["ItemType_E"]) { array_push($itemArr, "new ItemStack(".ucfirst($element["ItemType_E"])."Loader.".$element["Item_E"].", 1)");}

                        $tArr = array(
                            "OutputItem" => $element["OutputItem"],
                            "OutputItemType" => $element["OutputItemType"],
                            "OutputAmount" => $element["OutputAmount"],
                            "Items" => $itemArr,
                            );

                        array_push($shapeless, $tArr);

                        break;
                    
                    default:
                        # code...
                        break;
                }


                

            } else {
                //$this->line("Recipe is disabled. Skipping.",'red');
                continue;
            }   
                
            //$this->info("");
        }

        //generate the item script
        //make the blockloader
        //$this->line("Writing RecipeManager", 'yellow');
        //generate the code
        $itemloader = View::make('templates.recipemanager')->with(array(
            "smelting" => $smelting,
            "shapeless" => $shapeless
            ))->render();

        //output the blockload.java
        file_put_contents(Config::get('gen.codeDir')."RecipeManager.java", $itemloader);
        
        //$this->line("");
    	echo "done";
        //$this->line("--[Building Items: Complete]--", 'yellow');

    }


}
