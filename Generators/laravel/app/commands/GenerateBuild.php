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
		if($this->option('skipgen') == "FALSE") {
			$this->call('chemcraft:elements');
			$this->call('chemcraft:items');
			$this->call('chemcraft:recipes');
			$this->call('chemcraft:assets');
		}

		//echo $this->option('skipgen');

		//get the build number
		$build = $GenHelper->getNewBuildNumber();
		$GenHelper->updateBuildInConfig($build);
		$GenHelper->updateBuildInGame($build);

		//combine language files
		$this->line("--[Language Strings: Starting]--", 'yellow');
		$GenHelper->combineLang(Config::get('gen.langDir'), Config::get('gen.langProjectDir')."en_US.lang");
		$this->line("--[Language Strings: Complete]--", 'yellow');


		//Call "Build"
		$dir =Config::get('gen.projectGradleDir');
		
		$this->line("--[Building Jar: Starting]--", 'yellow');
		$this->line("Build Number: ".$build, 'yellow');

		
		$envir = 'OSX';
		//var_dump($_SERVER);
		if(isset($_SERVER['OS'])) {
			if(substr($_SERVER['OS'], 0, 7) == "Windows") {
				$envir = 'Windows';
			}
		}



		$this->line("Detected Environment: ".$envir, 'cyan');

		if($envir != 'Windows') {
			$cmd = 'build.sh';
			$finalCommand = '"'.$dir.$cmd.'"';
			$output = shell_exec($finalCommand);
		} else {
			//probably windows?
			$cmd = 'build.bat';
			$finalCommand = '"'.$dir.$cmd.'"';
			$this->line($finalCommand, 'yellow');
			
			//$commandForExec = 'cmd /c "'.$finalCommand.'" -p "'.$dir.'" build';
			//echo $commandForExec;
			//$output = system("cmd /c ".$finalCommand);
			$output = system($finalCommand);
			
		}
			
		
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
			array('skipgen', 'sg', InputOption::VALUE_OPTIONAL, 'Skip the generation of files, just build!', 'FALSE')
		);
	}

}
