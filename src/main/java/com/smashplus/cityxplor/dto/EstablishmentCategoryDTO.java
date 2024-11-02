package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentCategoryDTO {
    @JsonProperty("est_category_display")
    private String categoryTitle;
    @JsonProperty("image")
    private String image;
    @JsonProperty("category_dtl")
    private String teaser;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private int id;
    @JsonProperty("is_seo_display")
    private int seoDisplay;
    @JsonProperty("est_category")
    private String key; //Unique key for each category act as Id

    public EstablishmentCategoryDTO(String categoryTitle, String image, String teaser, String url, String key) {
        this.categoryTitle = categoryTitle;
        this.image = image;
        this.teaser = teaser;
        this.url = url;
        this.key = key;
    }

    public EstablishmentCategoryDTO() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeoDisplay() {
        return seoDisplay;
    }

    public void setSeoDisplay(int seoDisplay) {
        this.seoDisplay = seoDisplay;
    }
}
