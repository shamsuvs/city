package com.smashplus.cityxplor.controller;

import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;
import com.smashplus.cityxplor.service.BloggerService;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shamsudeen
 * Date: 1/24/16
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BloggerController {

    private static final String MISC_BLOGID = "9045371527724977539";
    @Autowired
    BloggerService bloggerService;


        private static final String CITY_BLOGID = "4697871309810697434";




    @RequestMapping(value="/{bid}-post/{title}-{pid}",method = {RequestMethod.GET})
    public String getPost(Model model, @PathVariable("bid") String bid, @PathVariable("pid") String pid, @PathVariable("title") String title, HttpServletRequest request) {
        try {

            Blogger blogger=bloggerService.getBloggerObj(request);

            model.addAttribute("blgid",bid);
            model.addAttribute("pid",pid);
            model.addAttribute("ptitle",title);
            String bParentId = bid;
            String indurl=null;
            // A known public activity ID

            if(bid.equalsIgnoreCase("city--sb")){
                bid = CITY_BLOGID;
                indurl="city--sb";

            }
            model.addAttribute("indexurl",indurl);
            model.addAttribute("title","blog");
            // The request action.
            Blogger.Posts.Get postsGetAction = blogger.posts().get(bid, pid);

           // Restrict the result content to just the data we need.
            postsGetAction.setFields("author/displayName,content,published,title,url,labels,images");
            postsGetAction.setFetchImages(true);

            // This step sends the request to the server.
            Post post = postsGetAction.execute();
            
            //bloggerService.savePostToDB(pid,bParentId,post);
            model.addAttribute("post",post);

            String content = post.getContent();

            String teaser = content.substring(content.indexOf("~~") + 2, content.lastIndexOf("~~"));
            model.addAttribute("teaser", teaser);

        }catch(Exception e){
            e.printStackTrace();

        }
        return "blog/blog-post";
    }



    @RequestMapping({"/city--sb/{label:^.*(?!lists)}"})
    public String getListOfStories(Model model, @PathVariable("label") String label, HttpServletRequest request) {
        try {


            // Now we can navigate the response.
            if(label.equalsIgnoreCase("all")){
                label="sb";
            }
            model.addAttribute("posts",getListOfBlogPosts(label,request,CITY_BLOGID, null));
            model.addAttribute("blogId","city--sb");
            model.addAttribute("isFirstPage",true);
            model.addAttribute("title",(label +" | Transportation"));
            model.addAttribute("indexurl","city--sb");
            model.addAttribute("urlStr","/transportation/"+label);
            model.addAttribute("target","Blog Posts");
        } catch (IOException e) {

            model.addAttribute("error","io error occurred");
            System.err.println(e.getMessage());
        } catch (Throwable t) {
            model.addAttribute("error","Exception occurred");
        }

        return "blog/blog-posts";
    }
    @Cacheable(value = "blog",key = "#label+#bid+#pageToken")
    public PostList getListOfBlogPosts(String label, HttpServletRequest request, String bid, String pageToken) throws IOException {
        Blogger blogger=bloggerService.getBloggerObj(request);
        // A known public activity ID
        String id = bid;
        // The request action.
        Blogger.Posts.List postsListAction = blogger.posts().list(id);
        //Restrict the result content to just the data we need.
        postsListAction.setFields("items(author/displayName,published,title,url,id,images,labels),nextPageToken");
        postsListAction.setLabels(label);
        if(ValConditions.isNotEmpty(pageToken)){
            postsListAction.setPageToken(pageToken);
        }
        postsListAction.setFetchImages(true);
        postsListAction.setFetchBodies(false);
        // This step sends the request to the server.
        PostList posts = postsListAction.execute();
        return posts;
    }

    @RequestMapping("/blog/{label}/{pageToken}")
    public String getListOfStoriesPages(Model model, @PathVariable("label") String label, @PathVariable("pageToken") String pageToken, HttpServletRequest request) {
        try {

            model.addAttribute("blogId","transportation");
            model.addAttribute("label",label);
            model.addAttribute("isNextPage",true);
            model.addAttribute("indexurl","city--sb");
            model.addAttribute("posts",getListOfBlogPosts(label,request,CITY_BLOGID,pageToken));

        } catch (IOException e) {

            model.addAttribute("error","io error occured");
        } catch (Throwable t) {
            model.addAttribute("error","Exception occured");
            t.printStackTrace();
        }
        return "blog/blog-posts";
    }


}



