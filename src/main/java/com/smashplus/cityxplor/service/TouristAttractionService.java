package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.dto.TouristAttractionDTO;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;

@Service
public class TouristAttractionService {
    // Autowired services for dependency injection
    @Autowired
    CommonRestService commonRestService;

    // Base website URL
    public static String SITE="https://www.sultanbathery.com";

    @Autowired
    CityRestService cityRestService;

    // Default constructor
    public TouristAttractionService() {
    }

    // Method 1: Get detailed profile of a specific tourist attraction
    public String getTouristAttractionProfile(Model model, HttpServletRequest request, String shortUrl, String param) {
        // Add canonical URL for SEO
        model.addAttribute("canonical","tourist-attraction/"+shortUrl);

        // Fetch attraction details using short URL
        TouristAttractionDTO attractionDTO = cityRestService.findAttractionOnShortUrl(param,null);

        // If attraction exists and has data
        if(ValConditions.isNotEmpty(attractionDTO)) {
            model.addAttribute("attraction", attractionDTO);
            return "tourist-attractions/attraction-detail";
        }

        // Handle error case
        model.addAttribute("errorMessage","Error in fetching the attraction details, try again");
        return "common/error404";
    }

    // Method 2: Fetch list of tourist attractions with sorting
    public List<TouristAttractionDTO> fetchTouristAttractions(String cityId, String sortField, String sortOrder) {
        try {
            String criterion = null;
            String ordsRestUrl="tourist_attractions/";

            // Build query criterion for API
            criterion = "{\"site\":\""+cityId+"\",\"$orderby\":{\""+sortField+"\":\""+sortOrder+"\"}}";

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // Convert API response to list of DTOs
            List<TouristAttractionDTO> attractions = mapper.convertValue(
                    commonRestService.getListGenericResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<TouristAttractionDTO>>() { });

            return attractions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method 3: Fetch attractions filtered by tags
    public List<TouristAttractionDTO> fetchTouristAttractionsByTags(String city, String type, String tag, String sortField) {
        try {
            String criterion = null;
            String ordsRestUrl="tourist_attractions/";

            // Build filter criterion if type is not "all"
            if(!"all".equals(type)){
                criterion = "{\""+type+"\":{\"$like\":\"%"+tag+"%\"}},\"$orderby\":{\""+sortField+"\":\"desc\"}}";
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // Get and convert filtered attractions
            List<TouristAttractionDTO> attractions = mapper.convertValue(
                    commonRestService.getListGenericResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<TouristAttractionDTO>>() { });

            return attractions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}