package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.service.TutorialService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TutorialController {
    final
    TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }
    @RequestMapping(value={"/tutorials"})
    public String viewTutorials(Model model, @RequestParam(required = false) String topic){

        model.addAttribute("tutor",tutorialService.getAllTutorials("1"));
        return "/tutor/all-tutorials";
    }
    @RequestMapping(value={"/{title}-tut{id}"})
    public String viewCourseDetails(Model model, @PathVariable String id, HttpServletRequest servletRequest, @PathVariable("title") String title) {

        tutorialService.getTutorial("tut"+id,model,servletRequest);
        return "/tutor/tutorial-view";
    }

    @RequestMapping(value={"/tutorial/{courseId}/{chapterTitle}-{id}"})
    public String viewChapter(Model model, @PathVariable String courseId, @PathVariable String id, HttpServletRequest servletRequest, @PathVariable("chapterTitle") String title) {

        tutorialService.getTutorial("tut"+id,model,servletRequest);
        model.addAttribute("step",tutorialService.getStepById(id));
        return "/course/chapter-view";
    }
}
