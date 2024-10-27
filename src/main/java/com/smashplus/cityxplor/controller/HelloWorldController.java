package com.smashplus.cityxplor.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = { "/home" }, method = { RequestMethod.GET })
    public String loadHome(Model model, HttpServletRequest req){


        try {
            // model.addAttribute("topposts",commonFcd.getTrendingPosts("trending"));
            return "index";
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    public String robots(HttpServletRequest request){
        return "forward:/seo/robots.txt";


    }
    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public String loadSitemap(HttpServletRequest request){
        return "forward:/seo/sitemap.xml";


    }

    @RequestMapping(value = "/ads.txt", method = RequestMethod.GET)
    public String loadAds(HttpServletRequest request){
        return "forward:/seo/ads.txt";


    }

}
