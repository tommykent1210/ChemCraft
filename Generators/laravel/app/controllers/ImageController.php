<?php

class ImageController extends BaseController {


	public function getIndex()
    {
        //
        echo "Generator Controller";
    }

    public function getTint($image, $hex)
    {
        $imageFile = public_path().'\\'.$image.".png";
        $imageNew =  public_path().'\\'.$image."_new.png";
        //echo $imageFile;
        //
        $GenHelper = new GenHelper();
        $rgb = $GenHelper->hex2rgb($hex);
        
		if ($GenHelper->tintImage($imageFile, $imageNew, $hex, 70)) {
            echo "Tinted Image";
            echo '<img src="http://localhost/public/'.$image.'_new.png" />';

        } else {
            echo "Tinting Failed";
        }
        $key = '1QTH9lcbZhGYVjq76S10LiFmDNtqj0YaTU3NVdeO-_Lc';


//        $this->line("--[ Building Elements: Started]--", 'yellow');
  //      $this->line("Getting spreadsheet from google...", 'yellow');
    //    $this->line("");

        $arr = $GenHelper->google_spreadsheet_to_array($key);
        var_dump($arr);

    }    
}
