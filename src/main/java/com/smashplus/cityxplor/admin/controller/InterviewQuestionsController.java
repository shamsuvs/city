package com.smashplus.cityxplor.admin.controller;

import com.smashplus.cityxplor.admin.service.IQMService;
import com.smashplus.cityxplor.domain.IntListingQtnMappingEntity;
import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import com.smashplus.cityxplor.domain.InterviewQuestionTblEntity;
import com.smashplus.cityxplor.repository.InterviewQtnListingTblRepository;
import com.smashplus.cityxplor.repository.InterviewQuestionTblRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InterviewQuestionsController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewQuestionsController.class);
    final InterviewQuestionTblRepository interviewQuestionTblRepository;
    final InterviewQtnListingTblRepository interviewQtnListingTblRepository;
    final
    IQMService iqmService;
   public InterviewQuestionsController(InterviewQuestionTblRepository interviewQuestionTblRepository, InterviewQtnListingTblRepository interviewQtnListingTblRepository, IQMService iqmService) {
       this.interviewQuestionTblRepository = interviewQuestionTblRepository;
       this.interviewQtnListingTblRepository = interviewQtnListingTblRepository;
       this.iqmService = iqmService;
   }
    @GetMapping(value="/admin/interview-question/create")
    public String getQuestionForm(Model model) {
        model.addAttribute("interview",new InterviewQuestionTblEntity());
        return "admin/interview/cms-addedit-iq";
    }
    @PostMapping(value="/admin/interview-question/create")
    public String add(Model model, HttpServletRequest request, @ModelAttribute("interview") InterviewQuestionTblEntity interview) {
        try {
            iqmService.save(interview);
            model.addAttribute("message","course submitted successfully.");
        }catch(Exception e){
        }
        return "redirect:/admin/interview-question/view/"+interview.getId();
    }
    @RequestMapping(value={"/admin/interview-question/view/{id}","/admin/interview-question/edit/{id}"})
    public String view(Model model, @PathVariable String id, HttpServletRequest servletRequest) {
        model.addAttribute("interview", iqmService.getIQ(Integer.parseInt(id)));
        if(servletRequest.getRequestURI().contains("edit")){
            model.addAttribute("edit","true");
            return "admin/interview/cms-addedit-iq";
        }else{
            model.addAttribute("view","true");
            return "admin/interview/cms-view-iq";
        }

    }
    @RequestMapping(value={"/admin/interview-question/all"})
    public String fetchAll(Model model, HttpServletRequest servletRequest) {

        model.addAttribute("iqList", iqmService.getAll());
        return "admin/interview/cms-iq-list";
    }

    //interview list Series(one step above)
    @RequestMapping(value="/admin/interview-questions-list/", method = {RequestMethod.GET})
    public String addTutorial(Model model) {
        model.addAttribute("iqsList",new InterviewQtnListingTblEntity());

        return "admin/interview/cms-add-edit-iqs";
    }
    @RequestMapping(value={"/admin/interview-questions-list/{id}","/admin/interview-questions-list/edit/{id}"})
    public String viewTutorial(Model model, @PathVariable String id, HttpServletRequest servletRequest) {

        iqmService.getList(id,model);
        if(servletRequest.getRequestURI().contains("edit")){
            model.addAttribute("edit","true");
            return "admin/interview/cms-add-edit-iqs";
        }else {
            model.addAttribute("view", "true");
            model.addAttribute("selEntityList",iqmService.getQuestionListOnListId(id));

            return "admin/interview/cms-view-iqs";
        }
    }
    @RequestMapping(value="/admin/interview-questions-list/", method = {RequestMethod.POST})
    public String addList(Model model, HttpServletRequest request, @ModelAttribute("iqsList") InterviewQtnListingTblEntity interviewQtnListingTblEntity) {
        try {
            iqmService.saveList(interviewQtnListingTblEntity);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/interview-questions-list/"+interviewQtnListingTblEntity.getId();
    }
    @GetMapping(value = { "/admin/interview-series/all" })
    public String loadAllExampleSeries(Model model, HttpServletRequest req) {

        try {
            logger.info("loading series");
            model.addAttribute("iqsList",interviewQtnListingTblRepository.findAll());
            logger.info("loading series end");
            return "admin/interview/all-iqs-list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


@RequestMapping(value = "/admin/interview-questions-list/list-int-questions", method = { RequestMethod.GET })
public String getQuestionsList(Model model, @RequestParam String category, @RequestParam String subCategory,
                               @RequestParam String listId
                               ) {
    List<InterviewQuestionTblEntity> entList1 = new ArrayList<>();

        List<InterviewQuestionTblEntity> entList = iqmService.getQuestionList(category, subCategory);
        List<InterviewQuestionTblEntity> selEntList = iqmService.getQuestionListOnListId(listId);

        for (InterviewQuestionTblEntity qtn : entList) {
            boolean flag = false;
            for (InterviewQuestionTblEntity sel : selEntList) {
                if (sel.getId()==(qtn.getId())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                entList1.add(qtn);
            }
        }

        model.addAttribute("questionList", entList1);
        model.addAttribute("searchCriteria",category+", "+subCategory);

    return "admin/interview/questions";
}
    @RequestMapping(value="/admin/interview-list/add-questions/", method = {RequestMethod.POST})
    public String addPostEntityMaps(Model model, @ModelAttribute("questionMap") IntListingQtnMappingEntity intListingQtnMapping, BindingResult result) {
        try{

            iqmService.saveMapping(intListingQtnMapping);

            model.addAttribute("message","post map added successfully.");

        }catch(Exception e){
            e.printStackTrace();

        }
        return "redirect:/admin/interview-questions-list/"+intListingQtnMapping.getIntListId();
    }
    @RequestMapping(value = "/admin/remove-intquest-mapping/{listId}/{questionId}", method = { RequestMethod.POST })
    @ResponseBody
    public String removeEntityPostMapping(Model model, @PathVariable String listId, @PathVariable String questionId, HttpServletRequest servletRequest) {

        iqmService.deleteQtnMapping(listId,questionId);
        return "removed successfully, refresh page";
    }
    }

