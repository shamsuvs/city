/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.smashplus.cityxplor.service.qanda;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.dto.TechPostDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * The Class BaseStackExchangeApiClient.
 */
public abstract class BaseStackExchangeApiClient extends
		StackExchangeApiGateway implements StackExchangeApiClient {
	@Override
	public PagedList<Question> getQuestions(long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION);
		String apiUrl = builder.withIds(questionIds)
				.withFilter("!6VvPDzQ)wlg1u")
				.buildUrl();

		return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	@Override
	public Question getQuestionsOnTags(String tag,int page) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION_TAGS);
		String apiUrl = builder
				.withFilter("withbody")
				.withParameters("tagged", Collections.singleton(tag))
				.withParameters("page", Collections.singleton(String.valueOf(page)))
				.withParameters("pagesize", Collections.singleton(String.valueOf(SVConstants.FETCH_PAGE_SIZE)))
				.withSort(Question.SortOrder.MOST_VOTED)
				.buildUrl();
		PagedList<Question> questionList=unmarshallList(Question.class, callApiMethod(apiUrl));
		Question detailQuestObj = null;


		for(Question questionObj:questionList){
			PagedList<Question> questionPagedList = getQuestions(questionObj.getQuestionId());
			if(questionPagedList!=null&questionPagedList.size()>0){
				detailQuestObj= questionPagedList.get(0);
				String tag2=null;
				if(questionObj.getTags().size()>1) {
					tag2=questionObj.getTags().get(1);
				}
				System.out.println(questionObj.getQuestionId());

				String acceptedAns = "";
				long secndId = 0;
				String  soUrl = "";
				long acceptedAnsId = detailQuestObj.getAcceptedAnswerId();

				//int index=0;
				int i=0;
				if(!detailQuestObj.getAnswers().get(0).isAccepted()){
					for(Answer answerObj:detailQuestObj.getAnswers()){
						if(acceptedAnsId==answerObj.getAnswerId()){
							acceptedAns = answerObj.getBody();
							//acceptedAnsId = answerObj.getAnswerId();
							//index = i;
						}else{
							if(i==1){
								secndId = answerObj.getAnswerId();
							}

						}
						i++;
						if(i==2){
							break;
						}

					}
				}

				TechPostDTO techPostDTO =new TechPostDTO("sv"+String.valueOf(questionObj.getQuestionId()+ new Random().nextInt(9)),questionObj.getTitle(),
						tag,questionObj.getBody(),String.valueOf(acceptedAnsId),acceptedAns);
				//questions1.get(0).getAnswers().get(0).getBody()
				techPostDTO.setCategory(tag);
				techPostDTO.setSubCategory(tag2);

				techPostDTO.setPrimaryTag(tag);
				techPostDTO.setSoUrl(questionObj.getLink());
				techPostDTO.setViewCount(questionObj.getViewCount());
				techPostDTO.setSoPostID(questionObj.getQuestionId());
				techPostDTO.setSecondaryTag(tag2);
				techPostDTO.setCreatedBy("shams");
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				Date today = new Date();

				Date todayWithZeroTime = null;
				try {
					String currDate=formatter.format(today);
					todayWithZeroTime = formatter.parse(currDate);
					System.out.println(currDate+" "+todayWithZeroTime);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				techPostDTO.setCreatedDate(todayWithZeroTime);
				String response = createPostJSON(techPostDTO);
				System.out.println(response);
			}



		}
		return detailQuestObj;
	}


	public String createPost(TechPostDTO techPostDTO) {
		RestTemplate rest = new RestTemplate();
		String url = "https://hkyhsgzdbc0teha-smashvoiddb.adb.ap-mumbai-1.oraclecloudapps.com/ords/shams/technology/posts/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("pid", techPostDTO.getPostId());
		headers.set("title", techPostDTO.getTitle());

		headers.set("ptag", techPostDTO.getPrimaryTag());
		headers.set("pbody", techPostDTO.getPostBody());
		headers.set("resid", techPostDTO.getPrimaryResponseId());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<TechPostDTO> respEntity = rest.exchange(url, HttpMethod.POST, entity, TechPostDTO.class);


		return "created success";
	}
	public String createPostJSON(TechPostDTO techPostDTO) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://hkyhsgzdbc0teha-smashvoiddb.adb.ap-mumbai-1.oraclecloudapps.com/ords/shams/technology/posts/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(techPostDTO);
			HttpEntity<String> request =
					new HttpEntity<String>(json, headers);
			String resutAsStr = restTemplate.postForObject(url, request, String.class);
			System.out.println(">>>Title:"+techPostDTO.getTitle());
		//
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Created Successfully In the TECHPOST table";
	}

	/**
	 * Creates the stack overflow api url builder.
	 *
	 * @param methodName
	 * the method name
	 *
	 * @return the api url builder
	 */
	protected abstract ApiUrlBuilder createStackOverflowApiUrlBuilder(
			String methodName);

	/**
	 * Instantiates a new base stack exchange api client.
	 *
	 * @param applicationKey
	 *            the application key
	 * @param accessToken
	 *            the access Token
	 * @param site
	 *            the stack exchange site
	 */
	protected BaseStackExchangeApiClient(String applicationKey,
										 String accessToken, StackExchangeSite site) {
		requestHeaders = new HashMap<String, String>();

		// by default we compress contents
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
		this.applicationKey = applicationKey;
		this.accessToken = accessToken;
		this.site = site;
	}

	/**
	 * Instantiates a new base stack exchange api client.
	 *
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 * @param apiVersion
	 *            the api version
	 */
	protected BaseStackExchangeApiClient(String applicationKey,
										 StackExchangeSite site, String apiVersion) {
		this(applicationKey, site);
		this.apiVersion = apiVersion;
	}
	/**
	 * Instantiates a new base stack exchange api client.
	 *
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 */
	protected BaseStackExchangeApiClient(String applicationKey,
										 StackExchangeSite site) {
		requestHeaders = new HashMap<String, String>();

		// by default we compress contents
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
		this.applicationKey = applicationKey;

		this.site = site;
	}

}

