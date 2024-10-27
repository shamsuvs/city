package com.smashplus.cityxplor.domain;

/**
 * Created with IntelliJ IDEA.
 * User: shamsudeen.s
 * Date: 6/13/17
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "blogpost")
public class BlogPost implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String idblogpost;
    private String title;
    private String url;
    private String label;
    private String site;
    private String thumbImage;
    private String shortUrl;
    private String blogId;
    private String category;
    private String subCategory;
    private int publish=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BlogPost() {
    }

    public BlogPost(String id, String title, String image) {
        this.idblogpost = id;
        this.title = title;
        this.thumbImage = image;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getIdblogpost() {
        return idblogpost;
    }

    public void setIdblogpost(String idblogpost) {
        this.idblogpost = idblogpost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }
}
