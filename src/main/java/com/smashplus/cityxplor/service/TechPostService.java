package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.dto.Response;
import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.TechPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class TechPostService {
    @Autowired
    HtmlFormatService htmlService;

    public List<TechPostDTO> getQuestions(String primaryTag) {
        List<TechPostDTO> posts = getQuestionsFromRest(primaryTag);
        System.out.println(">>>No of results returned:" + posts.size());
        return posts;
    }

    /**
     * Process command line.
     *
     * @param queryId the line
     * @return
     *@Cacheable(value = "svquestionprofile",key="#queryId")*/
    public TechPostDTO getQuestion(String queryId) {

        TechPostDTO question = getQuestionFromRest(queryId);
        if(question.getPostBody()!=null){
            question.setPostBody(htmlService.markdownToHtml(question.getPostBody()));
        }
        if(question.getCuratedAnswer()!=null){
            question.setCuratedAnswer(htmlService.markdownToHtml(question.getCuratedAnswer()));
        }

        if(question.getIsVersionSpecAnswer().equalsIgnoreCase("Y")) {
            question.setVersionRelatedAns(htmlService.markdownToHtml(question.getVersionRelatedAns()));
        }

        return question;


    }

    public TechPostDTO getQuestionFromRest(String qtnId) {
        RestTemplate restTemplate = new RestTemplate();
        //todo String url = RestUrlConstants.QUERY_PROFILE_URL+qtnId;
        String url = RestUrlConstants.QUERY_PROFILE_URL+qtnId;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        TechPostDTO techPostDTO = null;
        try {

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", "1");
            techPostDTO = restTemplate.getForObject(url, TechPostDTO.class, params);

            System.out.println(">>>Title:" + techPostDTO.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return techPostDTO;

    }

    public List<TechPostDTO> getQuestionsFromRest(String primaryTag) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RestUrlConstants.QUERY_LIST_URL_TAG+primaryTag ;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Response techPostsDTO = null;
        try {

            //Map<String, String> params = new HashMap<String, String>();
            //params.put("id", "1");
            techPostsDTO = restTemplate.getForObject(url, Response.class);// params);

            System.out.println(">>>No of results returned:" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return techPostsDTO.getItems();

    }
}
