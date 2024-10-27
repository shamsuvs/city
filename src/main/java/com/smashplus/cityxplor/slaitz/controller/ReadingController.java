package com.smashplus.cityxplor.slaitz.controller;

import com.smashplus.cityxplor.slaitz.dto.EntityDTO;
import com.smashplus.cityxplor.slaitz.dto.StoryDTO;
import com.smashplus.cityxplor.slaitz.fcd.StoryFacade;
import com.smashplus.cityxplor.slaitz.service.ReadingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReadingController {
    @Autowired
    ReadingService readingService;
    @Autowired
    StoryFacade storyFacade;

    @RequestMapping(value = { "/slaitz/" }, method = { RequestMethod.GET })
    public String loadIndex(Model model){
        try {
            model.addAttribute("page","index");
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/index";
    }
    @RequestMapping(value = { "/slaitz/{entityName}-object" }, method = { RequestMethod.GET })
    public String loadQuestionProfile(Model model, HttpServletRequest req, @PathVariable String entityName){


        model.addAttribute("page","home");
        model.addAttribute("entityName",entityName);
        try {
            EntityDTO entityDTO = readingService.getEntityObject(entityName);
            model.addAttribute("entity",entityDTO);
            model.addAttribute("objects",readingService.getAllEntityObjects());
            model.addAttribute("sentenceList",readingService.generateSingleObjectSentences(entityDTO));
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/entity-profile";
    }

    //Slaitz
    @RequestMapping(value = { "/slaitz/sentences" }, method = { RequestMethod.GET })
    public String listSentences(Model model){
        try {
                model.addAttribute("page","sentences");
                model.addAttribute("sentences",readingService.getSentencesFromRestService());
            }catch(Exception e){
                e.printStackTrace();
            }
        return "slaitz/read/sentences";
    }

    //
    @RequestMapping(value = { "/slaitz/phonics" }, method = { RequestMethod.GET })
    public String displayPhonics(Model model){
        try {
            model.addAttribute("page","sentences");
            model.addAttribute("phonics",readingService.fetchPhonics("mixed"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/phonics";
    }

    @RequestMapping(value = { "/slaitz/phonics/{type}" }, method = { RequestMethod.GET })
    public String displayVariousPhonics(Model model, @PathVariable String type){
        try {
            model.addAttribute("page","sentences");
            model.addAttribute("phonics",readingService.fetchOtherPhonics(type));
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/phonics";
    }

    //Slaitz
    @RequestMapping(value = { "/slaitz/stories" }, method = { RequestMethod.GET })
    public String listStories(Model model){
        try {
            model.addAttribute("page","story-list");
            model.addAttribute("stories",readingService.getShortStories());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/stories";
    }

    //Slaitz
    @RequestMapping(value = { "/slaitz/story/{id}" }, method = { RequestMethod.GET })
    public String listStory(Model model, @PathVariable String id){
        try {
            model.addAttribute("page","story-list");
            StoryDTO storyDTO = readingService.getShortStory(Integer.parseInt(id));
            model.addAttribute("storyParts",storyFacade.generateSmallParts(storyDTO));
            model.addAttribute("story",storyDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "slaitz/read/story";
    }
}
