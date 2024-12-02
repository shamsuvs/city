package com.smashplus.cityxplor.controller;

import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;
import com.smashplus.cityxplor.domain.CityTableEntity;
import com.smashplus.cityxplor.dto.EstablishmentCategoryDTO;
import com.smashplus.cityxplor.dto.NewsDTO;
import com.smashplus.cityxplor.service.BloggerService;
import com.smashplus.cityxplor.service.NewsService;
import com.smashplus.cityxplor.util.CommonUtil;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @Autowired
    CommonUtil commonUtil;

    private static final String CITY_BLOGID = "4697871309810697434";


    @RequestMapping(value = "/news/{shortUrl}", method = {RequestMethod.GET})
    public String getNewsDetails(Model model,HttpServletRequest req, @PathVariable("shortUrl") String shortUrl){

        try {
            Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);
            String s= newsService.getNewsProfile(model, req, shortUrl,shortUrl.substring(shortUrl.lastIndexOf("-")+1));
            return s;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @RequestMapping(value = "/all-wayanad-news", method = {RequestMethod.GET})
    public String fetchAllNews(Model model,HttpServletRequest req){

        try {
            Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);
            List<NewsDTO> newsDTOS= newsService.fetchLatestNews("sultan-bathery","created_date", "desc");
            model.addAttribute("newsList",newsDTOS);
            model.addAttribute("target", "Latest News - Sultan Bathery, Wayanad");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "blog/news-list";
    }

    @GetMapping({ "/tag-{tag}-news--{cityCode}"})
    public String getNEwsBasedOnTag(Model model,
                                                   HttpServletRequest request,
                                                   @PathVariable("cityCode") String cityCode,
                                                   @PathVariable("tag") String tag) {

        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sulthan-bathery";
        }
        model.addAttribute("city", city);
        model.addAttribute("target",tag);
        model.addAttribute("newsList", newsService.fetchLatestNewsOnTags("sultan-bathery","labels",tag,"created_date"));
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        model.addAttribute("categoryDto", categoryDTO);
        //model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "blog/news-list";
    }

}
