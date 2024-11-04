package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.GenericResponse;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CommonRestService {
    public GenericResponse getListGenericResponse(String restUrl, String param, String c){
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl ;
        if(ValConditions.isNotEmpty(param)){
            url=url+"/"+param;
        }
        if(ValConditions.isNotEmpty(c)){
            url=url+"?q={criterion}";
            // url=url.replace("{criterion}",c);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        /*riComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q",c)
                .build();*/
        GenericResponse responseDTO = null;
        try {

            responseDTO = restTemplate.getForObject(url, GenericResponse.class,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }
}
