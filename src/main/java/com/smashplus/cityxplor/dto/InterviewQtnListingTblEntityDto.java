package com.smashplus.cityxplor.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

public class InterviewQtnListingTblEntityDto implements Serializable {
    private final String id;
    private final String title;
    private final String teaser;
    private final String postDesc;
    private final String image;
    private final String author;
    private final Date updateDate;
    private final String category;
    private final String subcategory;
    private final String technology;
    private final String youtubeUrl;
    private final String tags;
    private final Collection<IntListingQtnMappingEntityDto> intListingQtnMappingsById;

    public InterviewQtnListingTblEntityDto(String id, String title, String teaser, String postDesc, String image, String author, Date updateDate, String category, String subcategory, String technology, String youtubeUrl, String tags, Collection<IntListingQtnMappingEntityDto> intListingQtnMappingsById) {
        this.id = id;
        this.title = title;
        this.teaser = teaser;
        this.postDesc = postDesc;
        this.image = image;
        this.author = author;
        this.updateDate = updateDate;
        this.category = category;
        this.subcategory = subcategory;
        this.technology = technology;
        this.youtubeUrl = youtubeUrl;
        this.tags = tags;
        this.intListingQtnMappingsById = intListingQtnMappingsById;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTeaser() {
        return teaser;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getTechnology() {
        return technology;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public String getTags() {
        return tags;
    }

    public Collection<IntListingQtnMappingEntityDto> getIntListingQtnMappingsById() {
        return intListingQtnMappingsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQtnListingTblEntityDto entity = (InterviewQtnListingTblEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.teaser, entity.teaser) &&
                Objects.equals(this.postDesc, entity.postDesc) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.updateDate, entity.updateDate) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.subcategory, entity.subcategory) &&
                Objects.equals(this.technology, entity.technology) &&
                Objects.equals(this.youtubeUrl, entity.youtubeUrl) &&
                Objects.equals(this.tags, entity.tags) &&
                Objects.equals(this.intListingQtnMappingsById, entity.intListingQtnMappingsById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, teaser, postDesc, image, author, updateDate, category, subcategory, technology, youtubeUrl, tags, intListingQtnMappingsById);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "teaser = " + teaser + ", " +
                "postDesc = " + postDesc + ", " +
                "image = " + image + ", " +
                "author = " + author + ", " +
                "updateDate = " + updateDate + ", " +
                "category = " + category + ", " +
                "subcategory = " + subcategory + ", " +
                "technology = " + technology + ", " +
                "youtubeUrl = " + youtubeUrl + ", " +
                "tags = " + tags + ", " +
                "intListingQtnMappingsById = " + intListingQtnMappingsById + ")";
    }
}
