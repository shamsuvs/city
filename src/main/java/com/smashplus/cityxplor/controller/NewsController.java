package com.smashplus.cityxplor.controller;

import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;
import com.smashplus.cityxplor.service.BloggerService;
import com.smashplus.cityxplor.service.NewsService;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shamsudeen
 * Date: 1/24/16
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NewsController {

    private static final String MISC_BLOGID = "9045371527724977539";
    @Autowired
    BloggerService bloggerService;

    @Autowired
    NewsService newsService;



    private static final String CITY_BLOGID = "4697871309810697434";


    @RequestMapping(value = "/news/{shortUrl}", method = {RequestMethod.GET})
    public String getNewsDetails(Model model,HttpServletRequest req, @PathVariable("shortUrl") String shortUrl){

        try {
            String s= newsService.getNewsProfile(model, req, shortUrl);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "blog/blog-post";
    }


}
