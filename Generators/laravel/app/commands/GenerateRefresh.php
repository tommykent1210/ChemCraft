<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class GenerateRefresh extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:refresh';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Refresh all generated code ChemCraft';

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
		$GenHelper = new GenHelper();

		//get the build number
		$build = $this->argument('buildnum');
		$GenHelper->updateBuildInGame($build);
		$this->line("--[Generating Assets for build: ".$build."]--", 'cyan');
		
		$this->call('chemcraft:elements');
		$this->call('chemcraft:items');
		$this->call('chemcraft:recipes');
		$this->call('chemcraft:assets');
	

		//echo $this->option('skipgen');



		//combine language files
		$this->line("--[Language Strings: Starting]--", 'yellow');
		$GenHelper->combineLang(Config::get('gen.langDir'), Config::get('gen.langProjectDir')."en_US.lang");
		$this->line("--[Language Strings: Complete]--", 'yellow');


		
			
		$this->line("--[Refresh: Complete]--", 'yellow');

	}

	/**
	 * Get the console command arguments.
	 *
	 * @return array
	 */
	protected function getArguments()
	{
		return array(
			array('buildnum', InputOption::VALUE_REQUIRED, 'Give the build number', '0')
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
