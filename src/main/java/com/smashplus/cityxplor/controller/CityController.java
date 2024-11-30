package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.domain.CityTableEntity;
import com.smashplus.cityxplor.domain.EstablishmentEntity;
import com.smashplus.cityxplor.dto.EstablishmentCategoryDTO;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.service.EstablishmentService;
import com.smashplus.cityxplor.service.ListService;
import com.smashplus.cityxplor.service.NewsService;
import com.smashplus.cityxplor.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CityController {
    @Autowired
    ListService listService;
    @Autowired
    CommonUtil commonUtil;

    final EstablishmentService establishments;
    final EstablishmentService establishmentService;
    final NewsService newsService;


    public CityController(EstablishmentService findEstablishments, EstablishmentService establishmentService, NewsService newsService) {
        this.establishments = findEstablishments;
        this.establishmentService = establishmentService;
        this.newsService = newsService;
    }

    @GetMapping({ "/old"})
    public String getCityProfile(Model model){
        String city = "sultan-bathery";
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        List<EstablishmentEntity> editorsPicks  = establishments.findEstablishmentsByFilter(cityTableEntity.getId(),null,"likes");
        model.addAttribute("editorsPicks", editorsPicks);
        List<EstablishmentEntity> establishmentEntities  = establishments.findEstablishmentsByFilter(cityTableEntity.getId(),null,"name");
        model.addAttribute("establishmentsAll", establishmentEntities);

        Map<String, List<EstablishmentEntity>> estabGroup =
                establishmentEntities.stream().collect(Collectors.groupingBy(w -> w.getCategory()!=null?w.getCategory():"other"));
        model.addAttribute("estabGroup", estabGroup);
        SortedSet<String> keys = new TreeSet<>(estabGroup.keySet());
        model.addAttribute("keys",keys);
        model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        return "city/index";

    }
    @GetMapping({ "/"})
    public String generateHomePage(Model model){
        String city = "sultan-bathery";
        model.addAttribute("city", city);
        CityTableEntity cityTableEntity = listService.findCity(city);
        model.addAttribute("cityObject", cityTableEntity);
        model.addAttribute("editorsPicks", establishmentService.findListOfEstablishments("sultan-bathery",null,"likes"));
        // model.addAttribute("editorsPicks", );

        List<EstablishmentEntity> entities  = new ArrayList<>();
        //model.addAttribute("editorsPicks", editorsPicks);
        List<EstablishmentDTO> establishmentEntities  =establishmentService.findListOfEstablishments("sultan-bathery",null,"name");
        model.addAttribute("establishmentsAll", establishmentEntities);
        establishmentEntities.stream().forEach(est-> {
            EstablishmentEntity e = new EstablishmentEntity();
            BeanUtils.copyProperties(est,e);
            e.setUrl(est.getUniqueSEOId());
            e.setEstName(est.getTitle());
            entities.add(e);
        });
        BeanUtils.copyProperties(establishmentEntities, entities);

        //   Map<String, List<EstablishmentEntity>> estabGroup =  establishmentEntities.stream().collect(Collectors.groupingBy(w -> w.)

        //   List<EstablishmentEntity> establishmentEntities  = establishments.findEstablishmentsByFilter(cityTableEntity.getId(),null,"name");
        model.addAttribute("establishmentsAll", establishmentEntities);

        Map<String, List<EstablishmentEntity>> estabGroup =
                entities.stream().collect(Collectors.groupingBy(w -> w.getCategory()!=null?w.getCategory():"other"));
        model.addAttribute("estabGroup", estabGroup);
        SortedSet<String> keys = new TreeSet<>(estabGroup.keySet());
        model.addAttribute("keys",keys);
        //model.addAttribute("categoryDto",commonUtil.getCategoryDTOMap());
        Map<String, EstablishmentCategoryDTO> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
        model.addAttribute("categoryDto", categoryDTO);
        model.addAttribute("news", newsService.fetchLatestNews("sultan-bathery",null,"title"));
        return "city/indexv2";

    }
}
