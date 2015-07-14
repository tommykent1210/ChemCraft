<?php 
ini_set('auto_detect_line_endings', TRUE);


class GenHelper {
	
	private $buildNumber = 0;
	/* Get a google spreadsheet and return its contents as an array */
	function google_spreadsheet_to_array($key) {
		// initialize URL
			$url = 'http://spreadsheets.google.com/feeds/cells/' . $key . '/1/public/values';
		// initialize curl
			$curl = curl_init();
		// set curl options
			curl_setopt($curl, CURLOPT_URL, $url);
			curl_setopt($curl, CURLOPT_HEADER, 0);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
		// get the spreadsheet using curl
			$google_sheet = curl_exec($curl);
		// close the curl connection
			curl_close($curl);
		// import the xml file into a SimpleXML object
			$feed = new SimpleXMLElement($google_sheet);
		// get every entry (cell) from the xml object
			// extract the column and row from the cell's title
			// e.g. A1 becomes [1][A]
			$array = array();


			foreach ($feed->entry as $entry) {

				$location = (string) $entry->title;
				preg_match('/(?P<column>[A-Z]+)(?P<row>[0-9]+)/', $location, $matches);
		   		$array[$matches['row']][$matches['column']] = (string) $entry->content;
			}
		// return the array
		$keys = array_shift($array);

		$finalArray = array();
		foreach ($array as $newArr) {
			

			$combined = array();
			foreach ($keys as $index => $key) {
				$combined[$key] = isset($newArr[$index]) ? $newArr[$index] : null;
			}

			if(substr($combined['Name'], 0,1) != "#" ) {
				array_push($finalArray, $combined);
			}
			
		}
		//exit;
		return $finalArray;
	}
	/*
		Get a google spreadsheet and return its contents as an array
		For version 3.0 of the Google Spreadsheet API, this requires the spreadsheet worksheet
		to be published as a web page. This function will parse through the generated HTML table
		to extract spreadsheet contents.
		This is because API v3 requires authentication and we don't want to put credentials in code.
	*/
	function google_spreadsheet_to_array_v3($url=NULL) {
		// make sure we have a URL
			if (is_null($url)) {
				return array();
			}
		// initialize curl
			$curl = curl_init();
		// set curl options
			curl_setopt($curl, CURLOPT_URL, $url);
			curl_setopt($curl, CURLOPT_HEADER, 0);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
		// get the spreadsheet data using curl
			$google_sheet = curl_exec($curl);
		// close the curl connection
			curl_close($curl);
		// parse out just the html table
			preg_match('/(<table[^>]+>)(.+)(<\/table>)/', $google_sheet, $matches);
			$data = $matches['0'];
		// Convert the HTML into array (by converting into HTML, then JSON, then PHP array
			$cells_xml = new SimpleXMLElement($data);
			$cells_json = json_encode($cells_xml);
			$cells = json_decode($cells_json, TRUE);
		// Create the array
			$array = array();
			foreach ($cells['tbody']['tr'] as $row_number=>$row_data) {
				$column_name = 'A';
				foreach ($row_data['td'] as $column_index=>$column) {
					$array[($row_number+1)][$column_name++] = $column;
				}
			}
		return $array;
	}

	function getNewBuildNumber() {
		$dir = public_path()."/build.txt";
		$currentBuild = intval(file_get_contents($dir));
		$newBuild = $currentBuild + 1;

		//update the build
		file_put_contents($dir, $newBuild);
		return $newBuild;
	}


	function updateBuildInGame($buildNum) {
		$this->buildNumber = $buildNum;
		$buildfile = Config::get('gen.langDir')."build_en_US.lang";
		$str = "ChemCraft_buildnum=".$buildNum;
		file_put_contents($buildfile, $str.PHP_EOL);
	}

	function tintImage($image, $newimage, $hex, $alpha) {

		//echo $imageFile;
        //
        $GenHelper = new GenHelper();
        $rgb = $GenHelper->hex2rgb($hex);
        
		$key = '1erWA95MmGF30nQcCpx4h89Z5kxwmbjFv04JSM5nCsoU';
        $im = imagecreatefrompng($image);
        //print_r($rgb);

        if($im && imagefilter($im, IMG_FILTER_COLORIZE, $rgb[0], $rgb[1], $rgb[2], $alpha))
        {
            
            imagesavealpha($im, true);
            imagepng($im, $newimage);
      		return true;
        }
        else
        {
            //echo 'Conversion to grayscale failed.';
            return false;
        }

        imagedestroy($im);

            //echo '<img src="http://localhost/public/'.$image.'_new.png" />';

	}

	function hueImage($image, $newimage, $hueAmount) {

		//echo $imageFile;
        //
        $GenHelper = new GenHelper();
        
        $im = imagecreatefrompng($image);
        //print_r($rgb);

        if($im)
        {
            $im = $GenHelper->imagehue($im, $hueAmount);
            imagesavealpha($im, true);
            imagepng($im, $newimage);
      		return true;
        }
        else
        {
            return false;
        }

        imagedestroy($im);

	}

	function hueImageDesat($image, $newimage, $hueAmount, $desatAmount) {

        $GenHelper = new GenHelper();        
        $im = imagecreatefrompng($image);
        //print_r($rgb);
        if($im)
        {
            $im = $GenHelper->imagehuedesat($im, $hueAmount, $desatAmount);
            imagesavealpha($im, true);
            imagepng($im, $newimage);
      		return true;
        }
        else
        {
            return false;
        }
        imagedestroy($im);
	}
	
	function hex2rgb($hex) {
	   $hex = str_replace("#", "", $hex);

	   if(strlen($hex) == 3) {
	      $r = hexdec(substr($hex,0,1).substr($hex,0,1));
	      $g = hexdec(substr($hex,1,1).substr($hex,1,1));
	      $b = hexdec(substr($hex,2,1).substr($hex,2,1));
	   } else {
	      $r = hexdec(substr($hex,0,2));
	      $g = hexdec(substr($hex,2,2));
	      $b = hexdec(substr($hex,4,2));
	   }
	   $rgb = array($r, $g, $b);
	   //return implode(",", $rgb); // returns the rgb values separated by commas
	   return $rgb; // returns an array with the rgb values
	}

	
	function imagehue($image, $angle) {
	    if($angle % 360 == 0) return;
		    $width = imagesx($image);
		    $height = imagesy($image);

		    for($x = 0; $x < $width; $x++) {
		        for($y = 0; $y < $height; $y++) {
		            $rgb = imagecolorat($image, $x, $y);
		            $r = ($rgb >> 16) & 0xFF;
		            $g = ($rgb >> 8) & 0xFF;
		            $b = $rgb & 0xFF;            
		            $alpha = ($rgb & 0x7F000000) >> 24;
		            list($h, $s, $l) = $this->rgb2hsl($r, $g, $b);
		            $h += $angle / 360;
		            if($h > 1) $h--;
		            list($r, $g, $b) = $this->hsl2rgb($h, $s, $l);            
		            imagesetpixel($image, $x, $y, imagecolorallocatealpha($image, $r, $g, $b, $alpha));
		        }
		    }
		    return $image;
	}
	
	function imagehuedesat($image, $angle, $desat) {
		$desat = $desat/100;
	    if($angle % 360 == 0) return;
		    $width = imagesx($image);
		    $height = imagesy($image);

		    for($x = 0; $x < $width; $x++) {
		        for($y = 0; $y < $height; $y++) {
		            $rgb = imagecolorat($image, $x, $y);
		            $r = ($rgb >> 16) & 0xFF;
		            $g = ($rgb >> 8) & 0xFF;
		            $b = $rgb & 0xFF;            
		            $alpha = ($rgb & 0x7F000000) >> 24;
		            list($h, $s, $l) = $this->rgb2hsl($r, $g, $b);
		            $h += $angle / 360;
		            if($h > 1) $h--;
		            //echo $s;
		            if($s - $desat > 0) {
		            	$s -= $desat;
		            }
		            list($r, $g, $b) = $this->hsl2rgb($h, $s, $l);            
		            imagesetpixel($image, $x, $y, imagecolorallocatealpha($image, $r, $g, $b, $alpha));
		        }
		    }
		    return $image;
	}
	

	function rgb2hsl($r, $g, $b) {
	   $var_R = ($r / 255);
	   $var_G = ($g / 255);
	   $var_B = ($b / 255);

	   $var_Min = min($var_R, $var_G, $var_B);
	   $var_Max = max($var_R, $var_G, $var_B);
	   $del_Max = $var_Max - $var_Min;

	   $v = $var_Max;

	   if ($del_Max == 0) {
	      $h = 0;
	      $s = 0;
	   } else {
	      $s = $del_Max / $var_Max;

	      $del_R = ( ( ( $var_Max - $var_R ) / 6 ) + ( $del_Max / 2 ) ) / $del_Max;
	      $del_G = ( ( ( $var_Max - $var_G ) / 6 ) + ( $del_Max / 2 ) ) / $del_Max;
	      $del_B = ( ( ( $var_Max - $var_B ) / 6 ) + ( $del_Max / 2 ) ) / $del_Max;

	      if      ($var_R == $var_Max) $h = $del_B - $del_G;
	      else if ($var_G == $var_Max) $h = ( 1 / 3 ) + $del_R - $del_B;
	      else if ($var_B == $var_Max) $h = ( 2 / 3 ) + $del_G - $del_R;

	      if ($h < 0) $h++;
	      if ($h > 1) $h--;
	   }

	   return array($h, $s, $v);
	}

	function hsl2rgb($h, $s, $v) {
	    if($s == 0) {
	        $r = $g = $B = $v * 255;
	    } else {
	        $var_H = $h * 6;
	        $var_i = floor( $var_H );
	        $var_1 = $v * ( 1 - $s );
	        $var_2 = $v * ( 1 - $s * ( $var_H - $var_i ) );
	        $var_3 = $v * ( 1 - $s * (1 - ( $var_H - $var_i ) ) );

	        if       ($var_i == 0) { $var_R = $v     ; $var_G = $var_3  ; $var_B = $var_1 ; }
	        else if  ($var_i == 1) { $var_R = $var_2 ; $var_G = $v      ; $var_B = $var_1 ; }
	        else if  ($var_i == 2) { $var_R = $var_1 ; $var_G = $v      ; $var_B = $var_3 ; }
	        else if  ($var_i == 3) { $var_R = $var_1 ; $var_G = $var_2  ; $var_B = $v     ; }
	        else if  ($var_i == 4) { $var_R = $var_3 ; $var_G = $var_1  ; $var_B = $v     ; }
	        else                   { $var_R = $v     ; $var_G = $var_1  ; $var_B = $var_2 ; }

	        $r = $var_R * 255;
	        $g = $var_G * 255;
	        $B = $var_B * 255;
	    }    
	    return array($r, $g, $B);
	}

	function combineLang($langFolder, $outputFile) {
		$path	 = $langFolder;				// Directory containing files
		$newFile  = $outputFile;			// Path to new file
		$fType	 = strtolower(substr($newFile, strpos($newFile, ".")));	// File type of files to collate (got automatically)
		$files	 = @scandir($path);
		unlink($newFile);

		if ($files)
		{
			//echo "Copying all $fType files from '<b>$path</b>' to '<b>$newFile</b>'<br /><br />";
			
			foreach($files as $file)
			{
				if (strlen($file) < 3)					continue;
				if (strtolower(substr($file, strpos($file, "."))) != $fType)	continue;
				if (strtolower($path.$file) == strtolower($newFile))		continue;
				
				$f  = fopen($path.$file, "r");
				
				if ($f)
				{
					$buff	= fread($f, filesize($path.$file));
					$f	= fclose($f);
				

					$f	= fopen($newFile, "a");
					
					if ($f)
					{
						fwrite($f, $buff);
						$f = fclose($f);
					}	
				}
			}
		}
	}

	function getItemBlockType($inputType) {
		switch (ucfirst($inputType)) {
			case 'Block':
				$inputType = 'BlockLoader';
				break;
			case 'Item':
				$inputType = 'ItemLoader';
				break;
			case 'VanillaBlock':
				$inputType = 'Blocks';
				break;
			case 'VanillaItem':
				$inputType = 'Items';
				break;
			
			default:
				$inputType = 'ItemLoader';
				break;
		}

		return $inputType;
	}

	function getItemStack($inputItem, $amount) {
		if (strstr($inputItem, ",")) {
			//echo $inputItem." x".$amount;
			//contains an item metadata
			$arr = explode(",", $inputItem);
			return 'new ItemStack('.$arr[0].', '.$amount.', '.$arr[1].')';
		} else {
			return 'new ItemStack('.$inputItem.', '.$amount.')';
		}
	}

	function recursiveCopy($source, $dest) {
		$num = 0;
		//mkdir($dest, 0755);
		foreach (
		 $iterator = new \RecursiveIteratorIterator(
		  new \RecursiveDirectoryIterator($source, \RecursiveDirectoryIterator::SKIP_DOTS),
		  \RecursiveIteratorIterator::SELF_FIRST) as $item
		) {
		  if ($item->isDir()) {
		    mkdir($dest . DIRECTORY_SEPARATOR . $iterator->getSubPathName());
		  } else {
		  	if($iterator->getSubPathName() != "desktop.ini") {
			  	$num += 1;
			    copy($item, $dest . DIRECTORY_SEPARATOR . $iterator->getSubPathName());
			}
		  }
		}
		return $num;
	}

}