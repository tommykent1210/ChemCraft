<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/
Route::get('wiki/', 'WikiController@showIndex');
Route::get('wiki/{page}', 'WikiController@showLanding');
Route::get('wiki/{cat}/{page}', 'WikiController@showPage');

Route::get('download', 'DownloadController@showIndex');
Route::get('download/go/{id}', 'DownloadController@showGo');
Route::get('download/direct/{id}', 'DownloadController@showDirect');
Route::get('download/landing/{id}', 'DownloadController@showLanding');
Route::get('download/source', 'DownloadController@showSource');


Route::get('/', 'HomeController@getIndex');
//Route::get('/', function()
//{
//	return View::make('site.home');
//});
