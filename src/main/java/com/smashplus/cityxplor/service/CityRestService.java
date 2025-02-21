package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.*;
import com.smashplus.cityxplor.util.CommonUtil;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CityRestService    {
    @Autowired
    CommonRestService commonRestService;
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
    public List<EstablishmentDTO> findEstablishmentsFilter(String cityId, String type, String value, String sortOrder) {
        try {
            String criterion = null;
            String ordsRestUrl="establishment_tbl/";
            //type="tags";

            if(!"all".equals(type)){
                criterion =  "{\""+type+"\":{\"$like\":\"%"+value+"%\"}},\"$orderby\":{\""+sortOrder+"\":\"asc\"}}";
            }
            List<EstablishmentDTO> response=getListResponse(ordsRestUrl,null,criterion).getItems();
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentDTO> findEstablishments(String cityId, String category, String sortOrder) {
        try {
            String criterion = null;
            String ordsRestUrl="establishment_tbl/";
            if(!"all".equals(category)){
                criterion =  "{\"category\":\""+category+"\",\"$orderby\":{\""+sortOrder+"\":\"asc\"}}";
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
           // url=url.replace("{criterion}",c);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        /*riComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q",c)
                .build();*/
        EstablishmentResponse responseDTO = null;
        try {
            /*ttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

            ResponseEntity<EstablishmentResponse> response = restTemplate.exchange(builder.toUriString(),HttpMethod.GET, requestEntity,
                    EstablishmentResponse.class);*/
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
    public EstablishmentDTO findEstablishmentProfileOnUrl(String url) {
        try {
            String ordsRestUrl="city/establishment-by-url/"+url;

            EstablishmentDTO response=getResponse(ordsRestUrl,null);
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public NewsDTO findNewsOnShortUrl(String param,String c) {
        try {
            String ordsRestUrl="sz_blog_posts/";
            String criterion = null;
            if(c!=null) {
                criterion = "{\"custom_url\":\"" + c + "\",\"$orderby\":{\"title\":\"asc\"}}";
            }

            return getNewsResponse(ordsRestUrl,param,criterion);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<DoctorDTO> findDoctorsOnSpecialty(String specialty) {
        try {
            //https://hkyhsgzdbc0teha-smashvoiddb.adb.ap-mumbai-1.oraclecloudapps.com/ords/shams/city/doctors/:speciality
            String criterion = null;
            String ordsRestUrl="city/doctors/"+specialty;
            ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<DoctorDTO> pojos = mapper.convertValue(
                    commonRestService.getListGenericResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<DoctorDTO>>() { });
            return pojos;

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
    private NewsDTO getNewsResponse(String restUrl, String param, String c){
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl ;
        if(ValConditions.isNotEmpty(param)){
            url=url+param;
        }
        if(ValConditions.isNotEmpty(c)){
            url=url+"?q={criterion}";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        NewsDTO responseDTO = null;
        try {

            responseDTO = restTemplate.getForObject(url, NewsDTO.class,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }

    public TouristAttractionDTO findAttractionOnShortUrl(String param, String c) {
        try {
            String ordsRestUrl="tourist-attractions/";
            String criterion = null;
            if(c!=null) {
                criterion = "{\"custom_url\":\"" + c + "\",\"$orderby\":{\"title\":\"asc\"}}";
            }

            return getTouristAttractionResponse(ordsRestUrl,param,criterion);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private TouristAttractionDTO getTouristAttractionResponse(String restUrl, String param, String c){
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.ORDS_PREFIX+restUrl ;
        if(ValConditions.isNotEmpty(param)){
            url=url+param;
        }
        if(ValConditions.isNotEmpty(c)){
            url=url+"?q={criterion}";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        TouristAttractionDTO responseDTO = null;
        try {

            responseDTO = restTemplate.getForObject(url, TouristAttractionDTO.class,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }

}
