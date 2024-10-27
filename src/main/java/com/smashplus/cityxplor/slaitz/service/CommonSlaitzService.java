package com.smashplus.cityxplor.slaitz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.slaitz.constants.RestUrlConstants;
import com.smashplus.cityxplor.slaitz.dto.EntityDTO;
import com.smashplus.cityxplor.slaitz.response.ObjResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shamsudeen
 * Date: 27/08/16
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CommonSlaitzService {


    public List<EntityDTO> fetchListsFromRest(String type, String filterCondition) {
        RestTemplate restTemplate = new RestTemplate();
        String url = null;
        if (type.equalsIgnoreCase("allobj")) {
        url = RestUrlConstants.ALL_OBJECTS;
        } else if (type.equalsIgnoreCase("filtobj")) {

            url = RestUrlConstants.OBJECT + filterCondition;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        ObjResponse response = null;
        try {
            response = restTemplate.getForObject(url, ObjResponse.class);
            System.out.println(">>>No of results returned:");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getItems();
        }

    public String postObject(String objname) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.OBJECT_MAIN;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        EntityDTO entityDTOObj = new EntityDTO();
        entityDTOObj.setEntityName(objname);
        entityDTOObj.setEntityGenName(objname);


        try {
          //  ResponseEntity<String> result = restTemplate.postForEntity(url, entityDTOObj, String.class);
            //System.out.println(">>>No of results returned:" );
            createPostJSON(entityDTOObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";

    }


    public String createPostJSON(EntityDTO entityDTO) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.OBJECT_MAIN;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(entityDTO);
            //System.out.println("ResultingJSONstring = " + json);
            HttpEntity<String> request =
                    new HttpEntity<String>(json, headers);
            String resutAsStr =
                    restTemplate.postForObject(url, request, String.class);
            System.out.println(">>>Title:"+entityDTO.getEntityName());
            System.out.println(resutAsStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



        //JsonNode root = objectMapper.readTree(personResultAsJsonStr);




        return "created success";
    }

}
