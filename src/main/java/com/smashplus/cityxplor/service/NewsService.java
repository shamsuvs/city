package com.smashplus.cityxplor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smashplus.cityxplor.domain.BlogPost;
import com.smashplus.cityxplor.dto.NewsDTO;
import com.smashplus.cityxplor.repository.BlogPostDAO;
import com.smashplus.cityxplor.util.CommonUtil;
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
    final BlogPostDAO blogPostDAO;
    public static String SITE="https://www.sultanbathery.com";

    public NewsService(BlogPostDAO blogPostDAO) {
        this.blogPostDAO = blogPostDAO;
    }

    public String getPost(Model model, HttpServletRequest request, @PathVariable("shortUrl") String shortUrl) {
        //request
        model.addAttribute("canonical",request.getRequestURI());
        String urlStr = request.getRequestURI().substring(1);

        System.out.println(urlStr);
        BlogPost blog = getPostOnShortURL(urlStr);
        /*if(ValConditions.isNotEmpty(blog)) {
           Post post = bloggerService.getPostOnId(blog.getBlogId(), blog.getIdblogpost(), request);
            model.addAttribute("post", post);
            model.addAttribute("subcategory",blog.getSubCategory());
            model.addAttribute("blog",blog.getCategory());
            model.addAttribute("socialImage","https://res.cloudinary.com/dw8him6rb/image/upload/v1603103037/Technology_vums9q.jpg");
            model.addAttribute("related",bloggerService.getRelatedPosts(post.getLabels(),blog.getIdblogpost()));
        }
*/
        return "blog/blog-post";
    }

    public BlogPost getPostOnShortURL(String shortUrl){
        BlogPost blogPost = blogPostDAO.findByShortUrlAndPublishEquals(shortUrl,1);
        return blogPost;
    }

    public List<BlogPost> getNews(){
        List<BlogPost> blogPosts = blogPostDAO.findBySiteAndPublishEquals(SITE,1);
        return blogPosts;
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
