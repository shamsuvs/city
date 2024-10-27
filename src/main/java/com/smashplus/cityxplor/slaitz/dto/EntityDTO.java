
package com.smashplus.cityxplor.slaitz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityDTO {

   
    private String article;
   
    private String behaviour;
   
    private String category;
    @JsonProperty("created_date")
    private String createdDate;
   
    private String description;
    @JsonProperty("ent_main_id")
    private Long entMainId;
    @JsonProperty("ent_teaser")
    private String entTeaser;
    @JsonProperty("entity_gen_name")
    private String entityGenName;
    @JsonProperty("entity_name")
    private String entityName;
   
    private String feature;
   
    private String gender;
   
    private String image;
    @JsonProperty("is_it")
    private String isIt;
    @JsonProperty("is_the")
    private String isThe;
    @JsonProperty("language_of_entry")
    private String languageOfEntry;
    @JsonProperty("modify_date")
    private String modifyDate;
    @JsonProperty("plural_form")
    private String pluralForm;
   
    private String specify;
    @JsonProperty("subcategory_l1")
    private String subcategoryL1;
    @JsonProperty("subcategory_l2")
    private String subcategoryL2;
   
    private String tags;

    private List<SentenceDTO> sentences;

    public EntityDTO(String word, String word1, String image, String subCategory) {
        this.entityGenName = word;
        this.entityName = word1;
        this.image=image;
        this.subcategoryL1=subCategory;

    }

    public EntityDTO() {

    }

    public String getArticle() {
        return article;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public String getCategory() {
        return category;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public Long getEntMainId() {
        return entMainId;
    }

    public String getEntTeaser() {
        return entTeaser;
    }

    public String getEntityGenName() {
        return entityGenName;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getFeature() {
        return feature;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public String getIsIt() {
        return isIt;
    }

    public String getIsThe() {
        return isThe;
    }

    public String getLanguageOfEntry() {
        return languageOfEntry;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public String getPluralForm() {
        return pluralForm;
    }

    public String getSpecify() {
        return specify;
    }

    public String getSubcategoryL1() {
        return subcategoryL1;
    }

    public String getSubcategoryL2() {
        return subcategoryL2;
    }

    public String getTags() {
        return tags;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEntMainId(Long entMainId) {
        this.entMainId = entMainId;
    }

    public void setEntTeaser(String entTeaser) {
        this.entTeaser = entTeaser;
    }

    public void setEntityGenName(String entityGenName) {
        this.entityGenName = entityGenName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIsIt(String isIt) {
        this.isIt = isIt;
    }

    public void setIsThe(String isThe) {
        this.isThe = isThe;
    }

    public void setLanguageOfEntry(String languageOfEntry) {
        this.languageOfEntry = languageOfEntry;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setPluralForm(String pluralForm) {
        this.pluralForm = pluralForm;
    }

    public void setSpecify(String specify) {
        this.specify = specify;
    }

    public void setSubcategoryL1(String subcategoryL1) {
        this.subcategoryL1 = subcategoryL1;
    }

    public void setSubcategoryL2(String subcategoryL2) {
        this.subcategoryL2 = subcategoryL2;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<SentenceDTO> getSentences() {
        return sentences;
    }

    public void setSentences(List<SentenceDTO> sentences) {
        this.sentences = sentences;
    }
}
