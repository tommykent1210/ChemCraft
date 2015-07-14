<?php

return array(

    /*
    |--------------------------------------------------------------------------
    | Default Colours
    |--------------------------------------------------------------------------
    |
    | The below options are used to specify the default colours to use.
    | This would usually be a black background and white text, change if 
    | you like.
    |
    */

    'default_background' => 'black',
    'default_text' => 'white',

    /*
    |--------------------------------------------------------------------------
    | Text ANSI Colours
    |--------------------------------------------------------------------------
    |
    | The used ANSI colours are specified below and can be changed if needed.
    | These colours are used for the text colour. (All text colours should
    | range from 30 - 37.)
    |
    */

    'text' => array(
        'black' => "\033[30m",
        'red' => "\033[31m",
        'green' => "\033[32m",
        'yellow' => "\033[33m",
        'blue' => "\033[34m",
        'magenta' => "\033[35m",
        'cyan' => "\033[36m",
        'white' => "\033[37m"
    ),

    /*
    |--------------------------------------------------------------------------
    | Background ANSI Colours
    |--------------------------------------------------------------------------
    |
    | The used ANSI colours are specified below and can be changed if needed.
    | These colours are used for the background colour. (All background colours
    | should range from 40 - 47.)
    |
    */

    'background' => array(
        'black' => "\033[40m",
        'red' => "\033[41m",
        'green' => "\033[42m",
        'yellow' => "\033[43m",
        'blue' => "\033[44m",
        'magenta' => "\033[45m",
        'cyan' => "\033[46m",
        'white' => "\033[47m"
    ),

);