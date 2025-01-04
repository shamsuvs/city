package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.domain.CityTableEntity;
import com.smashplus.cityxplor.domain.EstablishmentEntity;
import com.smashplus.cityxplor.dto.EstablishmentCategoryDTO;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.exception.SPException;
import com.smashplus.cityxplor.service.EstablishmentService;
import com.smashplus.cityxplor.service.ListService;
import com.smashplus.cityxplor.service.NewsService;
import com.smashplus.cityxplor.util.CommonUtil;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EstablishmentController {
    @Autowired
    ListService listService;
    @Autowired
    CommonUtil commonUtil;
   final EstablishmentService establishmentService;
   final NewsService newsService;

    public EstablishmentController(EstablishmentService establishmentService, NewsService newsService) {
        this.establishmentService = establishmentService;
        this.newsService = newsService;
    }


    @GetMapping({ "{estCode}-in--{cityCode}","all-establishments--{cityCode}"
    })
    public String getHospitals(Model model, HttpServletRequest request, @PathVariable(value = "estCode",required = false) String estCode, @PathVariable("cityCode") String cityCode) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
       // String target = "all";
       // target = findTarget(request);
        model.addAttribute("city", city);
       /* CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        String target = findTarget(request);
        */
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        if(ValConditions.isNotEmpty(categoryDTO.get(estCode))) {
            model.addAttribute("target", categoryDTO.get(estCode).getCategoryTitle());
            model.addAttribute("teaser", categoryDTO.get(estCode).getTeaser());
        }
        model.addAttribute("establishments", establishmentService.findListOfEstablishments("sultan-bathery",estCode));
        model.addAttribute("categoryDto",categoryDTO);
        return "city/business-list-v2";
    }
    @GetMapping({ "/tag-{tag}--{cityCode}"})
    public String getBusinessProfileListBasedOnTag(Model model,
                                                   HttpServletRequest request,
                                                   @PathVariable("cityCode") String cityCode,
                                                   @PathVariable("tag") String tag) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",tag);
        model.addAttribute("establishments", establishmentService.findListOfEstablishmentsFilter("sb","tags",tag,"title"));
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        model.addAttribute("categoryDto", categoryDTO);
        //model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "city/business-list";
    }




    @GetMapping({ "/{speciality}-doctors--{cityCode}"})
    public String getDoctorsBasedOnSpeciality(Model model, HttpServletRequest request, @PathVariable("cityCode") String cityCode, @PathVariable("speciality") String speciality) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",speciality);
        model.addAttribute("doctors", establishmentService.findDoctorsOnSpecialityFromRest(speciality, "sultan-bathery"));
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        model.addAttribute("categoryDto", categoryDTO);
        model.addAttribute("teaser",speciality +" Doctors in Sultan Bathery");
        model.addAttribute("listDet",listService.getListDetails(speciality));
        return "city/doctors-list";
    }
    @GetMapping({ "/sc-{sub-cat}--{cityCode}"})
    public String getBusinessProfileListBasedOnSc(Model model, HttpServletRequest request, @PathVariable("sub-cat") String subCat, @PathVariable("cityCode") String cityCode) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",subCat);
        //model.addAttribute("establishments", establishmentService.findEstablishmentsPublishedOnSubCategory(cityTableEntity.getId(),subCat));
        model.addAttribute("establishments", establishmentService.findListOfEstablishmentsFilter("sb","subcategory",subCat,"title"));
       // model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        model.addAttribute("categoryDto", categoryDTO);
        return "city/business-list";
    }
    private String findTargetO(HttpServletRequest request) {
        String target = "";
        String origReq = request.getRequestURL().toString();
        if(request.getRequestURL().toString().contains("hotel")){
            target="2";
        }else if(request.getRequestURL().toString().contains("hospitals")){
            target="1";
        }else if(request.getRequestURL().toString().contains("textile")){
            target="textile";
        }else if(request.getRequestURL().toString().contains("schools")){
            target="21";
        }else if(request.getRequestURL().toString().contains("colleges")){
            target="22";
        }else if(request.getRequestURL().toString().contains("temples")){
            target="temple";
        }else if(request.getRequestURL().toString().contains("all-")){
            target="all";
        }

        return target;
    }
    private String findTarget(HttpServletRequest request) {
        String target = "";
        String origReq = request.getRequestURL().toString();
        if(request.getRequestURL().toString().contains("hotel")){
            target="hotel";
        }else if(request.getRequestURL().toString().contains("hospitals")){
            target="hospital";
        }else if(request.getRequestURL().toString().contains("texti")){
            target="textile";
        }else if(request.getRequestURL().toString().contains("schools")){
            target="school";
        }else if(request.getRequestURL().toString().contains("colleges")){
            target="college";
        }else if(request.getRequestURL().toString().contains("temples")){
            target="temple";
        }else if(request.getRequestURL().toString().contains("all-")){
            target="all";
        }

        return target;
    }
    @GetMapping({ "/{estName}--{cityCode}"
    })
    public String getBusinessProfileAdv(@PathVariable("estName") String estName, @PathVariable("cityCode") String cityCode, Model model) throws SPException {
        //eg: /hotel-Jubilee-Restaurant-6--sb
        //sultan-bathery

        try {
            if(!cityCode.equals("sb")){
                throw new Exception("City Code Not acceptable");
            }
            EstablishmentDTO establishmentEntity =establishmentService.findEstablishmentProfileOnUrl(estName);
            model.addAttribute("entity", establishmentEntity);

            String city = cityCode;
            if (city.contains("sb")) {
                city = "sultan-bathery";
            }
            model.addAttribute("city", city);
            //CityTableEntity cityTableEntity = listService.findCity(city);
            //model.addAttribute("cityObject", cityTableEntity);
            //model.addAttribute("cityNews", newsService.getNews());

            model.addAttribute("relEntities", establishmentService.findListOfEstablishments("sultan-bathery",establishmentEntity.getCategory()));

            /*model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());*/
            Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);
        }catch (Exception e){
            throw new SPException("Error in fetching data: "+e.getMessage(),model);
        }
        return "city/business-profile-v2";

    }
    }
