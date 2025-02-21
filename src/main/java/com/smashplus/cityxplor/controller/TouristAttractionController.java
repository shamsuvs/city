package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.dto.TouristAttractionDTO;
import com.smashplus.cityxplor.service.TouristAttractionService;
import com.smashplus.cityxplor.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class TouristAttractionController {

    @Autowired
    private TouristAttractionService touristAttractionService;

    @Autowired
    private CommonUtil commonUtil;

    // 1. Fetch a detailed profile of a specific tourist attraction
    @RequestMapping(value = "/tourist-attraction/{shortUrl}", method = {RequestMethod.GET})
    public String getAttractionDetails(Model model, HttpServletRequest req,
                                       @PathVariable("shortUrl") String shortUrl) {
        try {
            // Fetch category map for the page (if needed for navigation or categorization)
            Map<String, ?> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);

            // Fetch attraction profile using the shortUrl
            String attractionDetailsPage = touristAttractionService.getTouristAttractionProfile(
                    model, req, shortUrl, shortUrl.substring(shortUrl.lastIndexOf("-") + 1)
            );
            return attractionDetailsPage; // Returns view name like "attraction-detail"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "common/error404"; // Return error page in case of failure
    }

    // 2. Fetch all tourist attractions for a city
    @RequestMapping(value = "/tourist-attractions", method = {RequestMethod.GET})
    public String fetchAllAttractions(Model model, HttpServletRequest req) {
        try {
            // Fetch category map
            Map<String, ?> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);

            // Fetch list of attractions
            List<TouristAttractionDTO> attractions = touristAttractionService.fetchTouristAttractions(
                    "Sultan-Bathery", "name", "asc"
            );
            model.addAttribute("attractionsList", attractions);
            model.addAttribute("target", "All Tourist Attractions - Sultan Bathery");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tourist-attractions/list"; // Return view for the list page
    }

    // 3. Fetch attractions based on tags
    @GetMapping({"/tag-{tag}-attractions--{cityCode}"})
    public String getAttractionsBasedOnTag(Model model,
                                           HttpServletRequest request,
                                           @PathVariable("cityCode") String cityCode,
                                           @PathVariable("tag") String tag) {
        String city = "";
        if (cityCode.equalsIgnoreCase("sb")) {
            city = "sultan-bathery";
        }

        model.addAttribute("city", city);
        model.addAttribute("target", tag);

        try {
            List<TouristAttractionDTO> attractions = touristAttractionService.fetchTouristAttractionsByTags(
                    city, "tags", tag, "name"
            );
            model.addAttribute("attractionsList", attractions);

            Map<String, ?> categoryDTO = commonUtil.getCategoryDTOMapFromRestService();
            model.addAttribute("categoryDto", categoryDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "tourist-attractions/list";
    }
}
