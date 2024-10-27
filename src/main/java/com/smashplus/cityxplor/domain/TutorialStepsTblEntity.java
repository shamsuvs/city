package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tutorial_steps_tbl", schema = "sp1", catalog = "")
public class TutorialStepsTblEntity {
    private int id;
    private String title;
    private String stepDesc;
    private String blogpostLink;
    private String contentType;
    private String tags;
    private String category;
    private String subcategory;
    private String ytCode;
    private Date modifyDate;
    private String screenShots;
    private Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "step_desc")
    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    @Basic
    @Column(name = "blogpost_link")
    public String getBlogpostLink() {
        return blogpostLink;
    }

    public void setBlogpostLink(String blogpostLink) {
        this.blogpostLink = blogpostLink;
    }

    @Basic
    @Column(name = "content_type")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
    @Column(name = "yt_code")
    public String getYtCode() {
        return ytCode;
    }

    public void setYtCode(String ytCode) {
        this.ytCode = ytCode;
    }

    @Basic
    @Column(name = "modify_date")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "screen_shots")
    public String getScreenShots() {
        return screenShots;
    }

    public void setScreenShots(String screenShots) {
        this.screenShots = screenShots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorialStepsTblEntity that = (TutorialStepsTblEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (stepDesc != null ? !stepDesc.equals(that.stepDesc) : that.stepDesc != null) return false;
        if (blogpostLink != null ? !blogpostLink.equals(that.blogpostLink) : that.blogpostLink != null) return false;
        if (contentType != null ? !contentType.equals(that.contentType) : that.contentType != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subcategory != null ? !subcategory.equals(that.subcategory) : that.subcategory != null) return false;
        if (ytCode != null ? !ytCode.equals(that.ytCode) : that.ytCode != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (screenShots != null ? !screenShots.equals(that.screenShots) : that.screenShots != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (stepDesc != null ? stepDesc.hashCode() : 0);
        result = 31 * result + (blogpostLink != null ? blogpostLink.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subcategory != null ? subcategory.hashCode() : 0);
        result = 31 * result + (ytCode != null ? ytCode.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (screenShots != null ? screenShots.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tutorialStepsTblByStepId")
    public Collection<TutStepsModuleMappingTblEntity> getTutStepsModuleMappingTblsById() {
        return tutStepsModuleMappingTblsById;
    }

    public void setTutStepsModuleMappingTblsById(Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById) {
        this.tutStepsModuleMappingTblsById = tutStepsModuleMappingTblsById;
    }
}
