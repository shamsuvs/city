package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.blogger.model.Post;
import com.smashplus.cityxplor.domain.BlogPost;
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
    BloggerService bloggerService;

    public NewsService(CityRestService cityRestService, BloggerService bs) {
        this.cityRestService = cityRestService;
        this.bloggerService  = bs;
    }

    public NewsService() {
    }


    public String getNewsProfile(Model model, HttpServletRequest request, String shortUrl) {
        //request
        model.addAttribute("canonical","news/"+shortUrl);

        System.out.println(shortUrl);
        NewsDTO newsDTO = cityRestService.findNewsOnShortUrl(shortUrl);
        if(ValConditions.isNotEmpty(newsDTO)) {
           Post post = bloggerService.getPostOnId(newsDTO.getBlogId(), newsDTO.getPostId(), request);
            model.addAttribute("post", post);
            model.addAttribute("socialImage","https://res.cloudinary.com/dw8him6rb/image/upload/v1603103037/Technology_vums9q.jpg");
            //model.addAttribute("related",bloggerService.getRelatedPosts(post.getLabels(),blog.getIdblogpost()));
        }

        return "success";
    }


    public List<NewsDTO> fetchLatestNews(String cityId, String category, String sortOrder) {
        try {
            String criterion = null;
            String ordsRestUrl="sz_blog_posts/";
            criterion =  "{\"site\":\""+cityId+"\",\"$orderby\":{\""+sortOrder+"\":\"asc\"}}";

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
