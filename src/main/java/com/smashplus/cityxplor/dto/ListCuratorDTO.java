
package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ListCuratorDTO {
    @JsonProperty("id")
    String id;


    @JsonProperty("key")
    String key;

    @JsonProperty("display_val")
    String displayVal;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String listDesc;
    @JsonProperty("site")
    String site;
    @JsonProperty("type")
    String type;
    @JsonProperty("sub_type")
    String subType;
    @JsonProperty("url")
    String url;
    @JsonProperty("image")
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDisplayVal() {
        return displayVal;
    }

    public void setDisplayVal(String displayVal) {
        this.displayVal = displayVal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListDesc() {
        return listDesc;
    }

    public void setListDesc(String listDesc) {
        this.listDesc = listDesc;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
