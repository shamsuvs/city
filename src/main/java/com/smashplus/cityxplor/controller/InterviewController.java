package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import com.smashplus.cityxplor.service.InterviewQtnListingTblService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterviewController {
    final
    InterviewQtnListingTblService interviewQtnListingTblService;

    public InterviewController(InterviewQtnListingTblService interviewQtnListingTblService) {
        this.interviewQtnListingTblService = interviewQtnListingTblService;
    }
    @RequestMapping(value={"/{title}-interview-questions-for-{targetExp}-years-experience"})
    public String viewInterviewSeries(Model model, @PathVariable String targetExp, @PathVariable("title") String technology) {

        InterviewQtnListingTblEntity interviewQtnListingTblEntity = interviewQtnListingTblService.getInterviewSeriesFiltered(technology, targetExp, model);
        model.addAttribute("targetExp",targetExp);
        interviewQtnListingTblEntity.setTitle(interviewQtnListingTblEntity.getTitle().replaceAll("#",targetExp));
        model.addAttribute("interview",interviewQtnListingTblEntity);
        return "/interview/inter-list-view";
    }
    @GetMapping(value={"/all-interview-series"})
    public String viewAllInterviewSeries(Model model) {

        model.addAttribute("interviewSeries",interviewQtnListingTblService.getAllInterviewSeries());
        return "/interview/all-list-view";
    }
    @RequestMapping(value={"/{title}-int{id}"})
    public String viewCourseDetails(Model model, @PathVariable String id, HttpServletRequest servletRequest, @PathVariable("title") String title) {

        interviewQtnListingTblService.getInterviewSeries("int"+id,model,servletRequest);
        return "/interview/inter-list-view";
    }
}
