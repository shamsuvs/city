package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.domain.BlogPost;
import com.smashplus.cityxplor.repository.BlogPostDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NewsService {
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
}
