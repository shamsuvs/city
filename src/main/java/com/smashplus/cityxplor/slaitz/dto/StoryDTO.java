
package com.smashplus.cityxplor.slaitz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryDTO {

    @JsonProperty
    private String author;
    @JsonProperty
    private String category;
    @JsonProperty
    private Long id;
    @JsonProperty
    private Object image;
    @JsonProperty
    private String splitchar;
    @JsonProperty
    private String story;
    @JsonProperty
    private String subcategory;
    @JsonProperty
    private String tags;
    @JsonProperty
    private String target;
    @JsonProperty
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getSplitchar() {
        return splitchar;
    }

    public void setSplitchar(String splitchar) {
        this.splitchar = splitchar;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
