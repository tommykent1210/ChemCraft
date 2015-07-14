# Laravel Artisan Colours #

A simple extension of the laravel `Illuminate\Console\Command` object to add some colour functionality.

Laravel's artisan already has some colour features using the `info`, `error`, `comment` and `line` methods, but it does not give you all of them. This package lets you
use all of the available ANSI colours with the `line` method.

## Install ##

Installation is nice and simple using composer.

Add the package to your `composer.json` file.

```
"require": {
    ...
    "jralph/laravel-artisan-colour": "1.*"
}
```

Once done, run a `composer update` and follow the setup below.

## Setup ##

Setup is nice and simple and only requires two steps.

1. Add `'Jralph\LaravelArtisanColour\LaravelArtisanColourServiceProvider',` to your `app/config/app.php` `providers` array.
2. Make sure that any classes you want to use the colours extend `Jralph\LaravelArtisanColour\Console\Command`.

## Usage ##

Using the colours is easy and straight forward.

Colours are only available on the `$this->line();` method as the others already have colours associated with them.

Syntax:

    - __With Background__: `$this->line('This is some text.', 'text_colour:background_colour');`
    - __Only Test__: `$this->line('This is some text.', 'text_colour');`

## Available Colours ##

Below is a list of all available text colour and background colours.

- Black
- White
- Red
- Green
- Blue
- Yellow
- Cyan
- Magenta

Using a combination of the above colours with the package will give you the desired text/background colours.

## Optional Config ##

The package also includes optional configuration that you may change if desired. 

Publish the config: `php artisan config:publish jralph/LaravelArtisanColour`

### config.php ###

This file contains a single option. Should the colours be output when using windows. 

If this option is true, the package will output the ansi colour codes. If you do not have your command line setup to read these codes and set the colours, then you may want to set this option to false.

### ansi.php ###

This file contains settings for all of the colours.

In this file you can set the default text colour (white) and default background colour (black).
