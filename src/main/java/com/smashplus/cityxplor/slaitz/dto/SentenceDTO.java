package com.smashplus.cityxplor.slaitz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SentenceDTO {

    @JsonProperty("article")
    String article;
    @JsonProperty("ent_main_id")
    String entityMainId;
    @JsonProperty("entity_name")
    String entityName;

    @JsonProperty("image")
    String entityImage;
    @JsonProperty("preposition")
    String preposition;
    @JsonProperty("targetid")
    String targetEntityId;
    @JsonProperty("targetname")
    String targetEntityName;

    @JsonProperty("nlarticle")
    String targetEntityArticle;

    String autoPopulatedForObject;
    //OfSentence
    String complexity;

    public String getEntityMainId() {
        return entityMainId;
    }

    public void setEntityMainId(String entityMainId) {
        this.entityMainId = entityMainId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getTargetEntityId() {
        return targetEntityId;
    }

    public void setTargetEntityId(String targetEntityId) {
        this.targetEntityId = targetEntityId;
    }

    public String getTargetEntityName() {
        return targetEntityName;
    }

    public void setTargetEntityName(String targetEntityName) {
        this.targetEntityName = targetEntityName;
    }

    public String getEntityImage() {
        return entityImage;
    }

    public void setEntityImage(String entityImage) {
        this.entityImage = entityImage;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTargetEntityArticle() {
        return targetEntityArticle;
    }

    public void setTargetEntityArticle(String targetEntityArticle) {
        this.targetEntityArticle = targetEntityArticle;
    }

    public String getAutoPopulatedForObject() {
        return autoPopulatedForObject;
    }

    public void setAutoPopulatedForObject(String autoPopulatedForObject) {
        this.autoPopulatedForObject = autoPopulatedForObject;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }
}
