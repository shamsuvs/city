package com.smashplus.cityxplor.slaitz.service;


import com.smashplus.cityxplor.slaitz.constants.RestUrlConstants;
import com.smashplus.cityxplor.slaitz.constants.StaticConstants;
import com.smashplus.cityxplor.slaitz.dto.EntityDTO;
import com.smashplus.cityxplor.slaitz.dto.PhonicsDTO;
import com.smashplus.cityxplor.slaitz.dto.SentenceDTO;
import com.smashplus.cityxplor.slaitz.dto.StoryDTO;
import com.smashplus.cityxplor.slaitz.response.GenericResponse;
import com.smashplus.cityxplor.slaitz.response.PhonicsResponse;
import com.smashplus.cityxplor.slaitz.response.Response;
import com.smashplus.cityxplor.service.qanda.HtmlService;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class ReadingService {
    @Autowired
    HtmlService htmlService;

    @Autowired
    CommonSlaitzService commonService;
/**
     * Process command line.
     *
     * @return
     */

    public EntityDTO getEntityObject(String entityName) {

        EntityDTO entityDTO = getEntityObjectDtls(entityName);
        if(ValConditions.isEmpty(entityDTO)){
            //insert into object table
            entityDTO = populateEntityDTO(generateEntityObjAfterFetchFromPhonics(entityName));
            commonService.createPostJSON(entityDTO);
        }
        //fetch again
        return entityDTO;


    }

    private EntityDTO populateEntityDTO(PhonicsDTO dto) {
        return new EntityDTO(dto.getWord(),dto.getWord(),dto.getImage(),dto.getSubCategory());
    }

    private PhonicsDTO generateEntityObjAfterFetchFromPhonics(String entityName) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://hkyhsgzdbc0teha-smashvoiddb.adb.ap-mumbai-1.oraclecloudapps.com/ords/shams/slaitz/phonicsmain?word="+entityName;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        PhonicsResponse response = null;
        try {
            response = restTemplate.getForObject(url, PhonicsResponse.class);
            System.out.println(">>>No of results returned:" +response.getItems().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getItems().get(0);
    }

    public EntityDTO getEntityObjectDtls(String objName) {
        List<EntityDTO> entityDTOList = commonService.fetchListsFromRest("filtobj",objName);
        if(entityDTOList.size()>0)
            return commonService.fetchListsFromRest("filtobj",objName).get(0);
        else return null;

    }


    public List<SentenceDTO> getSentencesFromRestService() {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.SENTENCES;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Response response = null;
        try {
            response = restTemplate.getForObject(url, Response.class);
            System.out.println(">>>No of results returned:" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getItems();

    }

    public List<EntityDTO> getAllEntityObjects() {
        return commonService.fetchListsFromRest("allobj",null);
    }

    public List<SentenceDTO> generateSingleObjectSentences(EntityDTO entityDTO) {
        List<SentenceDTO> sentenceList = new ArrayList<>();


        SentenceDTO sentenceDTO = new SentenceDTO();
        sentenceDTO.setAutoPopulatedForObject(createSentence(entityDTO.getSpecify(),entityDTO.getArticle(),entityDTO.getEntityName(),null));
        sentenceDTO.setComplexity("easy");
        sentenceList.add(sentenceDTO);

        sentenceDTO = new SentenceDTO();
        sentenceDTO.setAutoPopulatedForObject(createSentence(entityDTO.getSpecify(),entityDTO.getArticle(),entityDTO.getBehaviour(),entityDTO.getEntityName()));
        sentenceDTO.setComplexity("easy");
        sentenceList.add(sentenceDTO);

        sentenceDTO = new SentenceDTO();
        sentenceDTO.setAutoPopulatedForObject(createSentence(entityDTO.getSpecify(),entityDTO.getArticle(),entityDTO.getFeature(),entityDTO.getEntityName()));
        sentenceDTO.setComplexity("easy");
        sentenceList.add(sentenceDTO);

        sentenceDTO = new SentenceDTO();
        sentenceDTO.setAutoPopulatedForObject(createSentence("The" ,entityDTO.getArticle(),entityDTO.getEntityName(),entityDTO.getSubcategoryL1(),entityDTO.getCategory()));
        sentenceDTO.setComplexity("medium");
        sentenceList.add(sentenceDTO);
        sentenceDTO = new SentenceDTO();
        sentenceDTO.setAutoPopulatedForObject(createSentence("The",entityDTO.getEntityGenName() ,"is",entityDTO.getFeature()));
        sentenceDTO.setComplexity("easy");
        sentenceList.add(sentenceDTO);

        return sentenceList;
    }

    private String addSpace() {
        return " ";
    }
    private String createSentence(String... pArg) {
   // private String createSentence(String first, String second, String third, String fourth) {
        StringBuffer sentence = new StringBuffer();
        int i=1;
        for(String param:pArg){
            if(param!=null) {
                sentence.append(param);
                sentence.append(addSpace());
            }
            if(i==1){
                sentence.append(StaticConstants.IS);
                sentence.append(addSpace());
            }
            i++;
        }


        return sentence.toString();
    }
    public List<PhonicsDTO> fetchPhonics(String type) {
        RestTemplate restTemplate = new RestTemplate();
        String criterion = "{\"type\":\""+type+"\",\"$orderby\":{\"sub_category\":\"asc\"}}";
       // String url = "http://localhost:8080/spring-rest/api/get?criterion={criterion}";
        String url = RestUrlConstants.PHONICS_AUTO+"?q={criterion}";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        PhonicsResponse response = null;
        try {
            response = restTemplate.getForObject(url, PhonicsResponse.class,criterion);
            System.out.println(">>>No of results returned:" +response.getItems().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getItems();

    }

    public List<PhonicsDTO> fetchOtherPhonics(String type) {
        RestTemplate restTemplate = new RestTemplate();
        String criterion = "{\"sub_category\":\""+type+"\",\"$orderby\":{\"word\":\"asc\"}}";
        // String url = "http://localhost:8080/spring-rest/api/get?criterion={criterion}";
        String url = RestUrlConstants.PHONICS_AUTO+"?q={criterion}";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        PhonicsResponse response = null;
        try {
            response = restTemplate.getForObject(url, PhonicsResponse.class,criterion);
            System.out.println(">>>No of results returned:" +response.getItems().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getItems();

    }

    public List<StoryDTO> getShortStories() {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.STORY_MAIN;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        GenericResponse response = null;
        try {
            response = restTemplate.getForObject(url, GenericResponse.class);
            System.out.println(">>>Stories returned:" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<StoryDTO>) response.getItems();

    }

    public StoryDTO getShortStory(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.STORY_MAIN+id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        ResponseEntity<StoryDTO> response = null;
        try {
            //response = restTemplate.getForObject(url, GenericResponse.class);
            response = restTemplate.getForEntity(url,StoryDTO.class);
            System.out.println(">>>Stories returned:" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
}
