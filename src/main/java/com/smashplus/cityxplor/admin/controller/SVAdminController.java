package com.smashplus.cityxplor.admin.controller;

import com.smashplus.cityxplor.service.SmashAdminService;
import com.smashplus.cityxplor.service.qanda.StackExchangeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Admin Ctrl that handles all GET requests.
 */
@Controller
public class SVAdminController {
    @Autowired
    StackExchangeService stackExchangeService;
    @Autowired
    SmashAdminService techPostAdminService;

    /**
     * use to load the question from SO to SV
     * @param model
     * @param req
     * @param tagVal
     * @param pageNum
     * @return
     * sample url: /admin/tag/java?pageNum=5
     */
    @RequestMapping(value = { "/admin/tag/{tagVal}" }, method = { RequestMethod.GET })
    public String loadQuestionsOnTags(Model model, HttpServletRequest req, @PathVariable String tagVal, @RequestParam String pageNum){

        model.addAttribute("page","home");
        try {
            model.addAttribute("query",stackExchangeService.getQuestionOnTags(tagVal, Integer.parseInt(pageNum)));
        }catch(Exception e){
            e.printStackTrace();
        }


        return "admin/create-posts";
    }
    ///admin/sitemap-rls?site=smashvoid
    @RequestMapping(value = { "/admin/sitemap-urls" }, method = { RequestMethod.GET })
    public String loadQuestionsOnTags(Model model, HttpServletRequest req, @RequestParam String site){

        model.addAttribute("page","home");
        try {
            model.addAttribute("urls",techPostAdminService.generateSitemapUrls(site));
        }catch(Exception e){
            e.printStackTrace();
        }


        return "admin/sitemap-urls";
    }

}
