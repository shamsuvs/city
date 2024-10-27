
package com.smashplus.cityxplor.slaitz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class PhonicsDTO {

    @JsonProperty
    private String difficulty;
    @JsonProperty
    private Long id;
    @JsonProperty
    private String image;
    @JsonProperty("main_category")
    private String mainCategory;
    @JsonProperty("sub_category")
    private String subCategory;
    @JsonProperty
    private String type;
    @JsonProperty
    private String word;

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
