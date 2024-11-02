package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.EstablishmentCategoryDTO;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.dto.EstablishmentResponse;
import com.smashplus.cityxplor.dto.GenericResponse;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class EstablishmentCategoryService {

    public List<EstablishmentCategoryDTO> findEstablishmentCategory() {
        try {
            String criterion = null;
            String ordsRestUrl="est_category_tabl/";
            ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<EstablishmentCategoryDTO> pojos = mapper.convertValue(
                    getListResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<EstablishmentCategoryDTO>>() { });
           // List<EstablishmentCategoryDTO> response= (List<EstablishmentCategoryDTO>) getListResponse(ordsRestUrl,null,criterion).getItems();
            return pojos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private GenericResponse getListResponse(String restUrl, String param, String c){
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
