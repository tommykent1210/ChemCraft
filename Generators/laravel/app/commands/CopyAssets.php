<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class CopyAssets extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:assets';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Move around assets.';

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

		$this->line("--[Moving Assets: Started]--", 'yellow');
		$this->line("");

    	
        $elementCount = 0;
        
        //copy armor
        $this->line("Moving Armor Textures", 'yellow');
        $n = $GenHelper->recursiveCopy(Config::get('gen.spritesDir')."Armor".DIRECTORY_SEPARATOR,Config::get('gen.projectAssetDir')."armor".DIRECTORY_SEPARATOR);
        $elementCount += $n;
        $this->line("Moved ".$n." items.", 'green');
		$this->line("");

        //copy armoritems
        $this->line("Moving Armor Textures", 'yellow');
        $n = $GenHelper->recursiveCopy(Config::get('gen.spritesDir')."ArmorItems".DIRECTORY_SEPARATOR,Config::get('gen.projectTextureDir')."items".DIRECTORY_SEPARATOR);
        $elementCount += $n;
        $this->line("Moved ".$n." items.", 'green');
		$this->line("");        

        
		$this->line("Done. Copied ".$elementCount." assets.", 'magenta');
		$this->line("");
		
        $this->line("--[Moving Assets: Complete]--", 'yellow');
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
