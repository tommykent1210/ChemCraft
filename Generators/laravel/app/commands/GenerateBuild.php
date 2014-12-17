<?php

use Illuminate\Console\Command;
use Symfony\Component\Console\Input\InputOption;
use Symfony\Component\Console\Input\InputArgument;

class GenerateBuild extends Jralph\LaravelArtisanColour\Console\Command {

	/**
	 * The console command name.
	 *
	 * @var string
	 */
	protected $name = 'chemcraft:build';

	/**
	 * The console command description.
	 *
	 * @var string
	 */
	protected $description = 'Build ChemCraft';

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

		// Call Generators
		$this->call('chemcraft:elements');
		$this->call('chemcraft:items');
		$this->call('chemcraft:recipes');

		//combine language files
		$this->line("--[Language Strings: Starting]--", 'yellow');
		$GenHelper->combineLang(Config::get('gen.langDir'), Config::get('gen.langProjectDir')."en_US.lang");
		$this->line("--[Language Strings: Complete]--", 'yellow');

		//get the build number
		$build = $GenHelper->getNewBuildNumber();
		$GenHelper->updateBuildInConfig($build);

		//Call "Build"
		$dir =str_replace(" ", "\ ", Config::get('gen.projectGradleDir'));
		$cmd = 'build.sh';
		$this->line("--[Building Jar: Starting]--", 'yellow');
		$this->line("Build Number: ".$build, 'yellow');


		$output = shell_exec($dir.$cmd);
		$this->line($output, 'cyan');
		$this->line("--[Building Jar: Complete]--", 'yellow');

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
