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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
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
    @GetMapping({ "/"})
    public String getCityProfile(Model model){
        String city = "sultan-bathery";
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("editorsPicks", establishmentService.findListOfEstablishments("sultan-bathery",null,"likes"));
       // model.addAttribute("editorsPicks", );

        //List<EstablishmentEntity> editorsPicks  = establishments.findEstablishmentsByFilter(cityTableEntity.getId(),null,"likes");
        //model.addAttribute("editorsPicks", editorsPicks);
        List<EstablishmentDTO> establishmentEntities  =establishmentService.findListOfEstablishments("sultan-bathery",null,"name");
        model.addAttribute("establishmentsAll", establishmentEntities);

       // Map<String, List<EstablishmentEntity>> estabGroup =
         //       establishmentEntities.stream().collect(Collectors.groupingBy(w -> w.()!=null?w.getCategory():"other"));
        //model.addAttribute("estabGroup", estabGroup);
        //SortedSet<String> keys = new TreeSet<>(estabGroup.keySet());
       // model.addAttribute("keys",keys);
        model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "city/indexv2";

    }
    /*@GetMapping({ "/{estName}-hospital-{id}--{cityCode}",
            "/hotel-{estName}-{id}--{cityCode}",
            "/{estName}-college-{id}--{cityCode}",
            "/{estName}-school-{id}--{cityCode}",
            "/technology-{estName}-{id}--{cityCode}",
            "/textiles-{estName}-{id}--{cityCode}",
            "/tourist-attraction-{estName}-{id}--{cityCode}",
            "/{estName}-temple-{id}--{cityCode}",
            "/{estName}-ep-{id}--{cityCode}"
    })*/
    public String getBusinessProfile(@PathVariable("estName") String estName, @PathVariable("cityCode") String cityCode, @PathVariable("id") String id, Model model) throws SPException {
        //eg: /hotel-Jubilee-Restaurant-6--sb
        //sulthan-bathery

        try {
            if(!cityCode.equals("sb")){
                throw new Exception("City Code Not acceptable");
            }
            EstablishmentEntity establishmentEntity =establishmentService.findEstablishment(id);
            model.addAttribute("entity", establishmentEntity);

            String city = cityCode;
            if (city.contains("sb")) {
                city = "sultan-bathery";
            }
            model.addAttribute("city", city);
            CityTableEntity cityTableEntity = listService.findCity(city);
            model.addAttribute("cityObject", cityTableEntity);
            model.addAttribute("cityNews", newsService.getNews());
            model.addAttribute("relEntities", establishmentService.findEstablishmentsPublished(cityTableEntity.getId(),establishmentEntity.getCategory()));
            model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        }catch (Exception e){
            throw new SPException("Error in fetching data: "+e.getMessage(),model);
        }
        return "city/business-profile";

    }
    @GetMapping({ "/{estName}-hospital-{id}--{cityCode}",
            "/hotel-{estName}-{id}--{cityCode}",
            "/{estName}-college-{id}--{cityCode}",
            "/{estName}-school-{id}--{cityCode}",
            "/technology-{estName}-{id}--{cityCode}",
            "/textiles-{estName}-{id}--{cityCode}",
            "/tourist-attraction-{estName}-{id}--{cityCode}",
            "/{estName}-temple-{id}--{cityCode}",
            "/{estName}-ep-{id}--{cityCode}"
    })
    public String getBusinessProfileAdv(@PathVariable("estName") String estName, @PathVariable("cityCode") String cityCode, @PathVariable("id") String id, Model model) throws SPException {
        //eg: /hotel-Jubilee-Restaurant-6--sb
        //sulthan-bathery

        try {
            if(!cityCode.equals("sb")){
                throw new Exception("City Code Not acceptable");
            }
            EstablishmentDTO establishmentEntity =establishmentService.findEstablishmentProfile(id);
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
            model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        }catch (Exception e){
            throw new SPException("Error in fetching data: "+e.getMessage(),model);
        }
        return "city/business-profile-v2";

    }

    /*@GetMapping({ "/hospitals--{cityCode}",
            "/hotels--{cityCode}","/schools--{cityCode}","/textiles--{cityCode}","all-establishments--{cityCode}",
            "colleges--{cityCode}",
            "temples--{cityCode}",
    })*/
    public String getBusinessProfileList(Model model, HttpServletRequest request, @PathVariable("cityCode") String cityCode) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        String target = findTarget(request);
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMap();
        if(ValConditions.isNotEmpty(categoryDTO.get(target))) {
            model.addAttribute("target", categoryDTO.get(target).getCategoryTitle());
            model.addAttribute("teaser", categoryDTO.get(target).getTeaser());
        }
        model.addAttribute("establishments", establishmentService.findEstablishmentsPublished(cityTableEntity.getId(),target));
        /*model.addAttribute("cityNews", newsService.getNews());*/
        model.addAttribute("categoryDto",categoryDTO);
        return "city/business-list";
    }

    @GetMapping({ "/hospitals--{cityCode}",
            "/hotels--{cityCode}","/schools--{cityCode}","/textiles--{cityCode}","all-establishments--{cityCode}",
            "colleges--{cityCode}",
            "temples--{cityCode}",
    })
    public String getHospitals(Model model, HttpServletRequest request, @PathVariable("cityCode") String cityCode) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sultan-bathery";
        }
        String target = "all";
        target = findTarget(request);
        model.addAttribute("city", city);
       /* CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        String target = findTarget(request);
        */
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMap();
        if(ValConditions.isNotEmpty(categoryDTO.get(target))) {
            model.addAttribute("target", categoryDTO.get(target).getCategoryTitle());
            model.addAttribute("teaser", categoryDTO.get(target).getTeaser());
        }
        model.addAttribute("establishments", establishmentService.findListOfEstablishments("sultan-bathery",target));
        model.addAttribute("categoryDto",categoryDTO);
        return "city/business-list-v2";
    }
    @GetMapping({ "/tag-{tag}--{cityCode}"})
    public String getBusinessProfileListBasedOnTag(Model model, HttpServletRequest request, @PathVariable("cityCode") String cityCode, @PathVariable("tag") String tag) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sulthan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",tag);
        model.addAttribute("establishments", establishmentService.findEstablishmentsPublishedOnTags(cityTableEntity.getId(),tag));
        model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "city/business-list";
    }
    @GetMapping({ "/{speciality}-doctors-sulthan-bathery--{cityCode}"})
    public String getDoctorsBasedOnSpeciality(Model model, HttpServletRequest request, @PathVariable("cityCode") String cityCode, @PathVariable("speciality") String speciality) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sulthan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",speciality);
        model.addAttribute("doctors", establishmentService.findDoctorsOnSpeciality(speciality, cityTableEntity.getId()));
        model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        model.addAttribute("teaser",speciality +" Doctors in "+cityTableEntity.getCityName());
        model.addAttribute("listDet",listService.getListDetails(speciality));
        return "city/doctors-list";
    }
    @GetMapping({ "/sc-{sub-cat}--{cityCode}"})
    public String getBusinessProfileListBasedOnSc(Model model, HttpServletRequest request, @PathVariable("sub-cat") String subCat, @PathVariable("cityCode") String cityCode) {
        String city = "";
        if(cityCode.equalsIgnoreCase("sb")){
            city = "sulthan-bathery";
        }
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("target",subCat);
        model.addAttribute("establishments", establishmentService.findEstablishmentsPublishedOnSubCategory(cityTableEntity.getId(),subCat));
        model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "city/business-list";
    }
    private String findTarget(HttpServletRequest request) {
        String target = "";
        String origReq = request.getRequestURL().toString();
        if(request.getRequestURL().toString().contains("hotel")){
            target="2";
        }else if(request.getRequestURL().toString().contains("hospitals")){
            target="1";
        }else if(request.getRequestURL().toString().contains("texti")){
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

    }
