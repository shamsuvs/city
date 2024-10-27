package com.smashplus.cityxplor.domain;

import java.io.Serializable;
import java.util.Objects;

public class TutorialStepsTblEntityDto implements Serializable {
    private  int id;
    private  String title;
    private  String stepDesc;
    private  String blogpostLink;
    private  String contentType;
    private  String tags;
    private  String category;
    private  String subcategory;
    private  String ytCode;

    private  boolean addedToCourse;

    public boolean isAddedToCourse() {
        return addedToCourse;
    }

    public void setAddedToCourse(boolean addedToCourse) {
        this.addedToCourse = addedToCourse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public void setBlogpostLink(String blogpostLink) {
        this.blogpostLink = blogpostLink;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setYtCode(String ytCode) {
        this.ytCode = ytCode;
    }

    public TutorialStepsTblEntityDto() {
    }

    public TutorialStepsTblEntityDto(int id, String title, String stepDesc, String blogpostLink, String contentType, String tags, String category, String subcategory, String ytCode) {
        this.id = id;
        this.title = title;
        this.stepDesc = stepDesc;
        this.blogpostLink = blogpostLink;
        this.contentType = contentType;
        this.tags = tags;
        this.category = category;
        this.subcategory = subcategory;
        this.ytCode = ytCode;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public String getBlogpostLink() {
        return blogpostLink;
    }

    public String getContentType() {
        return contentType;
    }

    public String getTags() {
        return tags;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getYtCode() {
        return ytCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorialStepsTblEntityDto entity = (TutorialStepsTblEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.stepDesc, entity.stepDesc) &&
                Objects.equals(this.blogpostLink, entity.blogpostLink) &&
                Objects.equals(this.contentType, entity.contentType) &&
                Objects.equals(this.tags, entity.tags) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.subcategory, entity.subcategory) &&
                Objects.equals(this.ytCode, entity.ytCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, stepDesc, blogpostLink, contentType, tags, category, subcategory, ytCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "stepDesc = " + stepDesc + ", " +
                "blogpostLink = " + blogpostLink + ", " +
                "contentType = " + contentType + ", " +
                "tags = " + tags + ", " +
                "category = " + category + ", " +
                "subcategory = " + subcategory + ", " +
                "ytCode = " + ytCode + ")";
    }
}
