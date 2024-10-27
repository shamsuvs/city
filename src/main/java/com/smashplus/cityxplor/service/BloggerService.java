package com.smashplus.cityxplor.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.SecurityUtils;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.BloggerScopes;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: shamsudeen
 * Date: 6/24/16
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class BloggerService {
    /** Global instance of the HTTP transport. */
    private static HttpTransport httpTransport;
    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String id = "390582628921840995";
    private static final String TR_BLOGID = "5181880035896590018";




    /**
     * Be sure to specify the name of your application. If the application name is {@code null} or
     * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "pravasi";
    @Cacheable(value="blog",key = "#label")
    public PostList  getPosts(Blogger blogger, String label){
        try {
            // run commands
            // A known public activity ID
            // The request action.
            Blogger.Posts.List postsListAction = blogger.posts().list(id);
            // Restrict the result content to just the data we need.
            postsListAction.setFields("items(published,title,url,id),nextPageToken");
            if(!label.equals("all")){
                label=label.replaceAll("-",",");
                postsListAction.setLabels(label);
            }
            // This step sends the request to the server.
            PostList posts = postsListAction.execute();
             return posts;
            // Now we can navigate the response.

        } catch (IOException e) {


        } catch (Throwable t) {
        }

        return null;

    }


   public Blogger getBloggerObj(HttpServletRequest request){
        Blogger blogger=null;

        if(request.getSession().getAttribute("bloogerobj")!=null){
            blogger= (Blogger)request.getSession().getAttribute("bloogerobj");
        }
        if(blogger==null) {

            try {
                httpTransport = GoogleNetHttpTransport.newTrustedTransport();
                Credential credential = authorize();
                // set up global Oauth2 instance
                blogger = new Blogger.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(
                        APPLICATION_NAME).build();
                request.getSession().setAttribute("bloogerobj", blogger);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                
            }
            // authorization



        }
        return blogger;
    }
    /** Authorizes the installed application to access user's protected data. */
    private  Credential authorize() throws Exception {
        URI keyURL = this.getClass().getClassLoader().getResource("pravasi-4068d4e0498b.p12").toURI();
        InputStream keyURL1 = this.getClass().getClassLoader().getResourceAsStream("pravasi-4068d4e0498b.p12");


        PrivateKey privateKey = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), keyURL1, "notasecret", "privatekey", "notasecret");

        String emailAddress = "prav-713@pravasi-1198.iam.gserviceaccount.com";
        JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountId(emailAddress)
                .setServiceAccountPrivateKey(privateKey)
                .setServiceAccountScopes(Collections.singleton(BloggerScopes.BLOGGER))
                .build();

        // load client secrets

        // authorize
        return credential;
    }


    public Post getPostOnId(String blogId, String postId, HttpServletRequest request){
        Post post = null;
        try {
            if(blogId.equalsIgnoreCase("transportation")){
                blogId=TR_BLOGID;

            }
            Blogger blogger= getBloggerObj(request);
            // The request action.
            Blogger.Posts.Get postsGetAction = blogger.posts().get(blogId, postId);
            // Restrict the result content to just the data we need.
            postsGetAction.setFields("author/displayName,content,published,title,url,labels,images");
            postsGetAction.setFetchImages(true);

        // This step sends the request to the server.


            post = postsGetAction.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return post;
        }


    }

}
