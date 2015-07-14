<?php namespace JRalph\LaravelArtisanColour\Console;

use Illuminate\Console\Command as IlluminateCommand,
    Config;

class Command extends IlluminateCommand {

    public function line($string, $colour = null)
    {
        $windows = Config::get('LaravelArtisanColour::windows');
        
        if (!$colour || $this->option('no-ansi') || !$windows && strtoupper(substr(PHP_OS, 0, 3)) === 'WIN') {
            parent::line($string);
            return;
        }

        $text              = Config::get('LaravelArtisanColour::ansi.text');
        $background        = Config::get('LaravelArtisanColour::ansi.background');
        $textDefault       = Config::get('LaravelArtisanColour::ansi.default_text');
        $backgroundDefault = Config::get('LaravelArtisanColour::ansi.default_background');

        if (strpos($colour, ':') !== false) {
            $colours          = explode(':', $colour);
            $textColour       = $colours[0];
            $backgroundColour = $colours[1];

            $string = $text[$textColour].$background[$backgroundColour].$string.$background[$backgroundDefault].$text[$textDefault];
        } else {
            $string = $text[$colour].$string.$text[$textDefault];
        }

        parent::line($string);
    }

}