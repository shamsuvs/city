package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.dto.GenericResponse;
import com.smashplus.cityxplor.dto.HousekeepingDTO;
import com.smashplus.cityxplor.controller.RestUrlConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SmashAdminService {
   // loadSitemapUrls
   public List<HousekeepingDTO> generateSitemapUrls(String site) {

       RestTemplate restTemplate = new RestTemplate();
       String url = RestUrlConstants.HOUSEKEEPING_SITEMAP + "smashvoid";
       if(!site.isBlank()) {
            url = RestUrlConstants.HOUSEKEEPING_SITEMAP + site;
       }
       HttpHeaders headers = new HttpHeaders();
       headers.set("Content-Type", "application/json");
       GenericResponse response = null;
       try {
           response = restTemplate.getForObject(url, GenericResponse.class);
           System.out.println(">>>No of results returned:" +response.getItems().size());
       } catch (Exception e) {
           e.printStackTrace();
       }

       return (List<HousekeepingDTO>) response.getItems();
   }
}
