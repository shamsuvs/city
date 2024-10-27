
package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HousekeepingDTO {

    @JsonProperty
    private String comments;
    @JsonProperty("date_mod")
    private String date_mod;
    @JsonProperty
    private Long id;
    @JsonProperty
    private String site;
    @JsonProperty
    private String tags;
    @JsonProperty
    private String type;
    @JsonProperty
    private String url;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate_mod() {
        return date_mod;
    }

    public void setDate_mod(String date_mod) {
        this.date_mod = date_mod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
