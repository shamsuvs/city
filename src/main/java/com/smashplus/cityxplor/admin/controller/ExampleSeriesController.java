package com.smashplus.cityxplor.admin.controller;

import com.smashplus.cityxplor.admin.service.ESService;
import com.smashplus.cityxplor.domain.*;
import com.smashplus.cityxplor.repository.TutorialsTableEntityRepository;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ExampleSeriesController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleSeriesController.class);
    final
    TutorialsTableEntityRepository tutorialEntityRepository;
    @Autowired
    ESService esService;
    public ExampleSeriesController(TutorialsTableEntityRepository tutorialEntityRepository) {
        this.tutorialEntityRepository = tutorialEntityRepository;
    }

    //Tutorial//
    @RequestMapping(value="/admin/create-tutorial", method = {RequestMethod.GET})
    public String addTutorial(Model model) {
        model.addAttribute("tutorial",new TutorialsTableEntity());

        return "admin/es/cms-addedit-tut";
    }
    @RequestMapping(value={"/admin/view-tutorial/{id}","/admin/edit-tutorial/{id}"})
    public String viewTutorial(Model model, @PathVariable String id, HttpServletRequest servletRequest) {

        esService.getTut(id,model);
        if(servletRequest.getRequestURI().contains("edit")){
            model.addAttribute("edit","true");
            return "admin/es/cms-addedit-tut";
        }else {
            model.addAttribute("view", "true");

            return "admin/es/cms-view-tut";
        }
    }
    @RequestMapping(value="/admin/create-tutorial/", method = {RequestMethod.POST})
    public String addTutorial(Model model, HttpServletRequest request, @ModelAttribute("tutorial") TutorialsTableEntity tutorialsTableEntity, BindingResult bindingResult,
                            RedirectAttributes redirectAttrs) {
        try {
            esService.saveTutorial(tutorialsTableEntity);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/view-tutorial/"+tutorialsTableEntity.getId();
    }

    @GetMapping(value = { "/admin/all-es-articles" })
    public String loadAllExampleSeries(Model model, HttpServletRequest req) {

        try {
            logger.info("loading series");
            model.addAttribute("examples",tutorialEntityRepository.findAll());
            logger.info("loading series end");
            return "admin/es/all-list";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Step//
    //Steps
    @RequestMapping(value="/admin/create-step", method = {RequestMethod.GET})
    public String addStep(Model model) {
        model.addAttribute("step",new TutorialStepsTblEntity());
        return "admin/es/cms-addedit-step";
    }
    @RequestMapping(value="/admin/create-step", method = {RequestMethod.POST})
    public String addChapter(Model model, HttpServletRequest request, @ModelAttribute("step") TutorialStepsTblEntity step, BindingResult bindingResult) {
        try {
            esService.saveStep(step);
            model.addAttribute("message","course submitted successfully.");
        }catch(Exception e){
        }
        return "redirect:/admin/view-step/"+step.getId();
    }

    @RequestMapping(value={"/admin/view-step/{id}","/admin/edit-step/{id}"})
    public String viewChapter(Model model, @PathVariable String id, HttpServletRequest servletRequest) {
        model.addAttribute("step", esService.getStep(Integer.parseInt(id)));
        if(servletRequest.getRequestURI().contains("edit")){
            model.addAttribute("edit","true");
            return "admin/es/cms-addedit-step";
        }else{
            model.addAttribute("view","true");
            return "admin/es/cms-viewstep";
        }

    }
    @RequestMapping(value={"/admin/all-steps"})
    public String fetchAllChapters(Model model, HttpServletRequest servletRequest) {

        model.addAttribute("chapterList", esService.getAllSteps());
        return "admin/es/cms-steps";
    }
    //Module
    @RequestMapping(value="/admin/tutorial/add-module", method = {RequestMethod.POST})
    public String addChapter(Model model, HttpServletRequest request, @ModelAttribute("tutModule") TutorialModuleTblEntity tutorialModuleTbl, BindingResult bindingResult) {
        esService.saveModule(tutorialModuleTbl);
        return "redirect:/admin/view-tutorial/"+tutorialModuleTbl.getTutId();
    }
    //Mapping//
    @RequestMapping(value = "/admin/es/get-steps", method = { RequestMethod.GET },produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TutorialStepsTblEntityDto> getChapters(Model model, @RequestParam String title, @RequestParam(required = false) String type, @RequestParam(required = false) String tutId) {
        return esService.getSteps(title, type, tutId);
    }
        @RequestMapping(value="/admin/es/add-steps-module", method = {RequestMethod.POST})
        public String addChapterToModule(Model model, HttpServletRequest request,
                                         @ModelAttribute("moduleMap") TutStepsModuleMappingTblEntity tutStepsModuleMappingTblEntity) {

            List<TutStepsModuleMappingTblEntity> tutMapList = new ArrayList<TutStepsModuleMappingTblEntity>();
            String[] selectedChapters=request.getParameterValues("chaptersSel");
            String[] orderArray=request.getParameterValues("stepOrder");
            String tutId=tutStepsModuleMappingTblEntity.getTutId();
            String moduleId=tutStepsModuleMappingTblEntity.getModuleId();
            for(String stid:selectedChapters){
                TutStepsModuleMappingTblEntity entity = new TutStepsModuleMappingTblEntity();
                entity.setTutId(tutId);
                entity.setStepId(Integer.valueOf(stid));
                for(String order:orderArray){
                    if(ValConditions.isNotEmpty(order)&&order.split("-")[1].equals(stid)) {
                        entity.setStepOrder(order.split("-")[0]);
                        break;
                    }
                }
                entity.setModuleId(moduleId);
                entity.setMapTblId(new Random().nextInt(20000));
                tutMapList.add(entity);
            }
            esService.saveMap(tutMapList);
            System.out.println("on Controller");
            return "redirect:/admin/view-tutorial/"+tutId;
        }





        @RequestMapping(value = "/admin/delete-step/{id}", method = { RequestMethod.POST })
        @ResponseBody
        public String deleteChapter(Model model, @PathVariable String id, HttpServletRequest servletRequest) {

            esService.deleteStep(id);
            return "removed successfully, refresh page";
        }
        @RequestMapping(value = "/admin/es/delete-step-from-module/", method = { RequestMethod.POST })
        @ResponseBody
        public String deleteChapterFromModule(Model model, @RequestParam String moduleId, @RequestParam String stepId) {

            esService.deleteChapterFromModule(moduleId, stepId);
            return "removed successfully, refresh page";
        }
        @RequestMapping(value = "/admin/es/delete-module/", method = { RequestMethod.POST })
        @ResponseBody
        public String deleteModule(Model model, @RequestParam String moduleId) {

            esService.deleteModule(moduleId);
            return "removed successfully, refresh page";
        }
    }

