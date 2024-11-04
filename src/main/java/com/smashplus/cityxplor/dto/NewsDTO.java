package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsDTO {
    @JsonProperty("title")
    String title;
    @JsonProperty("custom_url")
    String customURL;
    @JsonProperty("blog_id")
    String blogId;
    @JsonProperty("post_id")
    String postId;
    @JsonProperty("image")
    String image;
    @JsonProperty("labels")
    String labels;
    @JsonProperty("teaser")
    String teaser;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomURL() {
        return customURL;
    }

    public void setCustomURL(String customURL) {
        this.customURL = customURL;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}
