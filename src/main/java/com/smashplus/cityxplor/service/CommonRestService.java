package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.GenericResponse;
import com.smashplus.cityxplor.dto.TouristAttractionDTO;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonRestService {

    // ✅ Fetch attraction by shortUrl (updated to accept additionalParam)
    public TouristAttractionDTO findAttractionOnShortUrl(String shortUrl, String additionalParam) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX + "tourist_attractions/short-url/" + shortUrl;

        if (ValConditions.isNotEmpty(additionalParam)) {
            url += "?param=" + additionalParam;
        }

        try {
            return restTemplate.getForObject(url, TouristAttractionDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    // ✅ Fetch a list of generic responses
    public GenericResponse getListGenericResponse(String restUrl, String param, String c) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX + restUrl;

        if (ValConditions.isNotEmpty(param)) {
            url = url + "/" + param;
        }
        if (ValConditions.isNotEmpty(c)) {
            url = url + "?q={criterion}";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        GenericResponse responseDTO = null;
        try {
            responseDTO = restTemplate.getForObject(url, GenericResponse.class, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }

    public GenericResponse getSingleGenericResponse(String restUrl, String param, String criterion) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX + restUrl;

        if (ValConditions.isNotEmpty(param)) {
            url = url + "/" + param;
        }
        if (ValConditions.isNotEmpty(criterion)) {
            url = url + "?q={criterion}";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        GenericResponse responseDTO = null;
        try {
            responseDTO = restTemplate.getForObject(url, GenericResponse.class, criterion);

            // If the response contains a list, return only the first item
            if (responseDTO != null && responseDTO.getItems() != null && !responseDTO.getItems().isEmpty()) {
                responseDTO.setItem(responseDTO.getItems().get(0)); // Assume setItem() exists
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }
}
