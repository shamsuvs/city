package com.smashplus.cityxplor.dto;

public class EstablishmentCategoryDTO {
    private String categoryTitle;
    private String image;
    private String teaser;
    private String url;
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
}
