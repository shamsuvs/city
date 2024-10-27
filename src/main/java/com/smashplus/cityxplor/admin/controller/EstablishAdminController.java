package com.smashplus.cityxplor.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.domain.EstablishmentEntity;
import com.smashplus.cityxplor.domain.SpecialityTblEntity;
import com.smashplus.cityxplor.dto.HousekeepingDTO;
import com.smashplus.cityxplor.dto.SiteMapResponse;
import com.smashplus.cityxplor.repository.CityTableEntityRepository;
import com.smashplus.cityxplor.repository.EstablishmentEntityRepository;
import com.smashplus.cityxplor.repository.SpecialityTblEntityRepository;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EstablishAdminController {
    private static final Logger logger = LoggerFactory.getLogger(EstablishAdminController.class);
    final CityTableEntityRepository cityTableEntityRepository;
    final EstablishmentEntityRepository establishmentEntityRepository;
    final SpecialityTblEntityRepository specialityTblEntityRepository;

    public EstablishAdminController(CityTableEntityRepository cityTableEntityRepository, EstablishmentEntityRepository establishmentEntityRepository, SpecialityTblEntityRepository specialityTblEntityRepository) {
        this.cityTableEntityRepository = cityTableEntityRepository;
        this.establishmentEntityRepository = establishmentEntityRepository;
        this.specialityTblEntityRepository = specialityTblEntityRepository;
    }

    @RequestMapping(value = {"/admin/all-est"})
    public String fetchAll(Model model) {

            model.addAttribute("estList", establishmentEntityRepository.findAll());
        return "admin/city/cms-est-list";
    }

    //interview list Series(one step above)
    @RequestMapping(value = "/admin/establishment/create", method = {RequestMethod.GET})
    public String addEst(Model model) {
        model.addAttribute("establishment", new EstablishmentEntity());

        return "admin/city/cms-add-edit-est";
    }

    @RequestMapping(value = {"/admin/establishment/view/{id}", "/admin/establishment/edit/{id}"})
    public String viewEstablishment(Model model, @PathVariable String id, HttpServletRequest servletRequest) {

        model.addAttribute("establishment", establishmentEntityRepository.findById(Integer.parseInt(id)).get());
        if (servletRequest.getRequestURI().contains("edit")) {
            model.addAttribute("edit", "true");
            model.addAttribute("id", id);
            return "admin/city/cms-add-edit-est";
        } else {
            model.addAttribute("view", "true");
            return "admin/city/cms-view-est";
        }
    }

    @RequestMapping(value = "/admin/establishment/create", method = {RequestMethod.POST})
    public String addEstablishment(Model model, HttpServletRequest request, @ModelAttribute("establishment") EstablishmentEntity establishmentEntity) {
        try {


            establishmentEntityRepository.save(establishmentEntity);
            Optional<String> specParam = Optional.ofNullable(request.getParameter("no-spec"));
            System.out.println(request.getParameter("no-spec"));
            if(specParam.isEmpty()){


            List<SpecialityTblEntity> specialityTblEntityList=new ArrayList<>();
            List<SpecialityTblEntity> delSpecialityTblEntityList=new ArrayList<>();
            establishmentEntity.getSpecialityTblsById().forEach(spec-> {
                spec.setActive(true);
                spec.setThumbNail("https://res.cloudinary.com/dw8him6rb/image/upload/v1664169743/qatar-world-cup/players/icons8-test-account-96.png");
                spec.setEstabId(establishmentEntity.getId());});

            for(SpecialityTblEntity specialityTblEntity:establishmentEntity.getSpecialityTblsById()){
                if(specialityTblEntity.getName().equals("todelete")) {
                    delSpecialityTblEntityList.add(specialityTblEntity);
                }else{
                    if(ValConditions.isNotEmpty(specialityTblEntity.getName())) {
                        specialityTblEntityList.add(specialityTblEntity);
                    }
                }
            }
            specialityTblEntityRepository.saveAll(specialityTblEntityList);
            specialityTblEntityRepository.deleteAll(delSpecialityTblEntityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/all-est";
    }
   /* @GetMapping(value = { "/admin/interview-series/all" })
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
    }*/
   public List<HousekeepingDTO> generateSitemapUrls(String site) {

       RestTemplate restTemplate = new RestTemplate();
       String url = RestUrlConstants.HOUSEKEEPING_SITEMAP + "smashvoid";
       if(ValConditions.isNotEmpty(site)) {
           url = RestUrlConstants.HOUSEKEEPING_SITEMAP + site;
       }
       HttpHeaders headers = new HttpHeaders();
       headers.set("Content-Type", "application/json");
       SiteMapResponse response = null;
       List<HousekeepingDTO> housekeepingDTOList = null;
       try {
           response = restTemplate.getForObject(url, SiteMapResponse.class);

           ObjectMapper objectMapper = new ObjectMapper();
           // housekeepingDTOList = objectMapper.readValue(restTemplate.getForObject(url, String.class), new TypeReference<List<HousekeepingDTO>>() {});
           System.out.println(">>>No of results returned:" +response.getItems().size());
       } catch (Exception e) {
           e.printStackTrace();
       }

       return response.getItems();
   }
}
