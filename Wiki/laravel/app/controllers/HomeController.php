<?php 

class HomeController extends BaseController {

    /**
     * Initializer.
     *
     * @return \HomeController
     */

    public function getIndex() {
        
        //$twitter = Twitter::getUserTimeline(array('screen_name' => 'chemcraftmc', 'count' => 8, 'format' => 'object'));

        //echo App::environment();
    	//return View::make('site.home')->with(array('twitter' => $twitter));
    	return View::make('site.home');
    }

}