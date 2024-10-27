package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.dto.EstablishmentResponse;
import com.smashplus.cityxplor.dto.ListResponse;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CityRestService    {
    public ListResponse getResponseObj(String restUrl, String qParam){

        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl;

        URI uri = UriComponentsBuilder
                .fromUri(URI.create(url))
                .queryParam("q", qParam)
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        try {
            ListResponse responseDTO= restTemplate.exchange(uri , HttpMethod.GET, null, ListResponse.class).getBody();
            return responseDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentDTO> findEstablishments(String cityId, String category) {
        try {
            String criterion = null;
            String ordsRestUrl="establishment_tbl/";
            if(!"all".equals(category)){
               criterion =  "{\"category\":\""+category+"\",\"$orderby\":{\"title\":\"asc\"}}";
            }
            List<EstablishmentDTO> response=getListResponse(ordsRestUrl,null,criterion).getItems();
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private EstablishmentResponse getListResponse(String restUrl, String param, String c){
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl ;
        if(ValConditions.isNotEmpty(param)){
            url=url+"/"+param;
        }
        if(ValConditions.isNotEmpty(c)){
            url=url+"?q={criterion}";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        EstablishmentResponse responseDTO = null;
        try {
            responseDTO = restTemplate.getForObject(url, EstablishmentResponse.class,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }


    public EstablishmentDTO findEstablishmentProfile(String id) {
        try {
            String ordsRestUrl="city/establishment/"+id;

            EstablishmentDTO response=getResponse(ordsRestUrl,null);
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public EstablishmentDTO getResponse(String restUrl, String param){
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl ;
        if(ValConditions.isNotEmpty(param)){
            url=url+"/"+param;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        EstablishmentDTO responseDTO = null;
        try {
            responseDTO = restTemplate.getForObject(url, EstablishmentDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }
}
