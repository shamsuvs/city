package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.blogger.model.Post;
import com.smashplus.cityxplor.domain.BlogPost;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.dto.NewsDTO;
import com.smashplus.cityxplor.repository.BlogPostDAO;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    CommonRestService commonRestService;

    public static String SITE="https://www.sultanbathery.com";
    @Autowired
    CityRestService cityRestService;
    @Autowired
    BloggerService bloggerService;



    public NewsService() {
    }


    public String getNewsProfile(Model model, HttpServletRequest request, String shortUrl, String param) {
        //request
        model.addAttribute("canonical","news/"+shortUrl);

        System.out.println(shortUrl);
        NewsDTO newsDTO = cityRestService.findNewsOnShortUrl(param,null);
        if(ValConditions.isNotEmpty(newsDTO)&&newsDTO.getPostId()!=null) {
           Post post = bloggerService.getPostOnId(newsDTO.getBlogId(), newsDTO.getPostId(), request);
            model.addAttribute("post", post);
            model.addAttribute("socialImage","https://res.cloudinary.com/dw8him6rb/image/upload/v1603103037/Technology_vums9q.jpg");
            //model.addAttribute("related",bloggerService.getRelatedPosts(post.getLabels(),blog.getIdblogpost()));
            model.addAttribute("news", newsDTO);
            return "blog/blog-post";
        }else if(ValConditions.isNotEmpty(newsDTO)&&newsDTO.getPostId()==null){

            model.addAttribute("news", newsDTO);
            return  "blog/short-news-post";
        }
        model.addAttribute("errorMessage","Error in fetching the news details, try again");
        return "common/error404";
    }


    public List<NewsDTO> fetchLatestNews(String cityId,String sortField, String sortOrder) {
        try {
            String criterion = null;
            String ordsRestUrl="sz_blog_posts/";
            criterion =  "{\"site\":\""+cityId+"\",\"$orderby\":{\""+sortField+"\":\""+sortOrder+"\"}}";

            ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<NewsDTO> pojos = mapper.convertValue(
                    commonRestService.getListGenericResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<NewsDTO>>() { });
            pojos.stream().forEach(newsDTO -> newsDTO.setCustomURL(newsDTO.getCustomURL()+"-"+newsDTO.getId()));
            return pojos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public  List<NewsDTO> fetchLatestNewsOnTags(String city, String type, String tag, String sortField) {
        try {
            String criterion = null;
            String ordsRestUrl="sz_blog_posts/";
            //type="tags";

            if(!"all".equals(type)){
                criterion =  "{\""+type+"\":{\"$like\":\"%"+tag+"%\"}},\"$orderby\":{\""+sortField+"\":\"desc\"}}";
               // criterion =  "{\""+type+"\":{\"$and\":[{\"$like\":\"%"+tag+"%\"},{\"site\":{\"$eq\":\""+city+"\"}}]},\"$orderby\":{\""+sortField+"\":\"desc\"}}";
               /// {
                  //  "SALARY": {"$and": [{"$gt": 1000},{"ENAME": {"$like":"S%"}} ] }
                //}https://docs.oracle.com/en/database/oracle/oracle-rest-data-services/24.3/orddg/developing-REST-applications.html#GUID-091748F8-3D14-402B-9310-25E6A9116B47

            }
            ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<NewsDTO> pojos = mapper.convertValue(
                    commonRestService.getListGenericResponse(ordsRestUrl,null,criterion).getItems(),
                    new TypeReference<List<NewsDTO>>() { });
            return pojos;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
}
