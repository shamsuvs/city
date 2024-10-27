package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.domain.CityTableEntity;
import com.smashplus.cityxplor.domain.EstablishmentEntity;
import com.smashplus.cityxplor.service.EstablishmentService;
import com.smashplus.cityxplor.service.ListService;
import com.smashplus.cityxplor.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Controller
public class CityController {
    @Autowired
    ListService listService;
    @Autowired
    CommonUtil commonUtil;

    final EstablishmentService establishments;

    public CityController(EstablishmentService findEstablishments) {
        this.establishments = findEstablishments;
    }

    @GetMapping({ "/"})
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
}
