<?php

/*
|--------------------------------------------------------------------------
| Register The Artisan Commands
|--------------------------------------------------------------------------
|
| Each available Artisan command must be registered with the console so
| that it is available to be called. We'll register every command so
| the console gets access to each of the command object instances.
|
*/


Artisan::add(new GenerateItems);
Artisan::add(new GenerateBlocks);
Artisan::add(new GenerateRecipes);
Artisan::add(new GenerateVanilla);
Artisan::add(new GenerateWikiItems);
Artisan::add(new NewDownload);
Artisan::add(new NewVersion);
Artisan::add(new Refresh);