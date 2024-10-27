package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.dto.TechPostDTO;
import com.smashplus.cityxplor.fcd.TechPostFacade;
import com.smashplus.cityxplor.service.TechPostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TechPostController {
    @Autowired
    TechPostService techPostService;

    @Autowired
    TechPostFacade techPostFacade;
    @RequestMapping(value = { "/questions/{primarytag}" }, method = { RequestMethod.GET })
    public String loadQuestions(Model model, HttpServletRequest req, @PathVariable String primarytag){

        model.addAttribute("page","home");
        model.addAttribute("tagref",primarytag);
        try {
            model.addAttribute("posts",techPostService.getQuestions(primarytag));
            model.addAttribute("trendingPosts",techPostService.getQuestions(primarytag));
        }catch(Exception e){
            e.printStackTrace();
        }
        return "query/posts";
    }
    @GetMapping(value = { "/{title}-sv{id}" })
    public String loadQuestionProfile(Model model, @PathVariable String id, @PathVariable String title){

        model.addAttribute("page","home");
        model.addAttribute("title",title);
        try {
            String qid = "sv"+id;
          //  model.addAttribute("query",techPostService.getQuestion(qid));
            TechPostDTO postDTO = techPostFacade.getQuestion(qid);
            model.addAttribute("query",postDTO);
            model.addAttribute("trendingPosts",techPostService.getQuestions(postDTO.getCategory()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return "query/query-profile";
    }
}
