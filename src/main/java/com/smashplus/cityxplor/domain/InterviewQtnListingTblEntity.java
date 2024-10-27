package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "interview_qtn_listing_tbl", schema = "sp1", catalog = "")
public class InterviewQtnListingTblEntity {
    private String id;
    private String title;
    private String teaser;
    private String postDesc;
    private String image;
    private String author;
    private Date updateDate;
    private String category;
    private String subcategory;
    private String technology;
    private String youtubeUrl;
    private String tags;
    private String targetExperience;
    private String url;
    private boolean publish;
    private Collection<IntListingQtnMappingEntity> intListingQtnMappingsById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "teaser")
    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    @Basic
    @Column(name = "post_desc")
    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "subcategory")
    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Basic
    @Column(name = "technology")
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Basic
    @Column(name = "youtube_url")
    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewQtnListingTblEntity that = (InterviewQtnListingTblEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (postDesc != null ? !postDesc.equals(that.postDesc) : that.postDesc != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subcategory != null ? !subcategory.equals(that.subcategory) : that.subcategory != null) return false;
        if (technology != null ? !technology.equals(that.technology) : that.technology != null) return false;
        if (youtubeUrl != null ? !youtubeUrl.equals(that.youtubeUrl) : that.youtubeUrl != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (postDesc != null ? postDesc.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subcategory != null ? subcategory.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        result = 31 * result + (youtubeUrl != null ? youtubeUrl.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "interviewQtnListingTblByIntListId")
    public Collection<IntListingQtnMappingEntity> getIntListingQtnMappingsById() {
        return intListingQtnMappingsById;
    }

    public void setIntListingQtnMappingsById(Collection<IntListingQtnMappingEntity> intListingQtnMappingsById) {
        this.intListingQtnMappingsById = intListingQtnMappingsById;
    }

    @Basic
    @Column(name = "target_experience")
    public String getTargetExperience() {
        return targetExperience;
    }

    public void setTargetExperience(String targetExperience) {
        this.targetExperience = targetExperience;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }
}
