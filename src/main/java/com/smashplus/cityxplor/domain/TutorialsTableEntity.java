package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tutorials_table", schema = "sp1")
public class TutorialsTableEntity {
    private String id;
    private String title;
    private String teaser;
    private String tutDescription;
    private String topic;
    private String author;
    private Date updateDate;
    private String image;
    private String techList;
    private boolean publish=false;
    private String tags;
    private String codeLink;
    private String codeNotes;
    private String tutReference;
    private String tutCategory;
    private String tutSubcategory;
    private String ytCode;
    private Collection<FaqTable> faqs;

    private Collection<RelatedLinkTable> related;
    private Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById;

    private Collection<TutorialModuleTblEntity> tutorialModuleTblEntities;
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
    @Column(name = "tut_description")
    public String getTutDescription() {
        return tutDescription;
    }

    public void setTutDescription(String tutDescription) {
        this.tutDescription = tutDescription;
    }

    @Basic
    @Column(name = "topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "tech_list")
    public String getTechList() {
        return techList;
    }

    public void setTechList(String techList) {
        this.techList = techList;
    }

    @Basic
    @Column(name = "publish")
    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
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
    @Column(name = "code_link")
    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }

    @Basic
    @Column(name = "code_notes")
    public String getCodeNotes() {
        return codeNotes;
    }

    public void setCodeNotes(String codeNotes) {
        this.codeNotes = codeNotes;
    }

    @Basic
    @Column(name = "tut_reference")
    public String getTutReference() {
        return tutReference;
    }

    public void setTutReference(String tutReference) {
        this.tutReference = tutReference;
    }

    @Basic
    @Column(name = "tut_category")
    public String getTutCategory() {
        return tutCategory;
    }

    public void setTutCategory(String tutCategory) {
        this.tutCategory = tutCategory;
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
    @Column(name = "tut_subcategory")
    public String getTutSubcategory() {
        return tutSubcategory;
    }

    public void setTutSubcategory(String tutSubcategory) {
        this.tutSubcategory = tutSubcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorialsTableEntity that = (TutorialsTableEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (tutDescription != null ? !tutDescription.equals(that.tutDescription) : that.tutDescription != null)
            return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (techList != null ? !techList.equals(that.techList) : that.techList != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (codeLink != null ? !codeLink.equals(that.codeLink) : that.codeLink != null) return false;
        if (codeNotes != null ? !codeNotes.equals(that.codeNotes) : that.codeNotes != null) return false;
        if (tutReference != null ? !tutReference.equals(that.tutReference) : that.tutReference != null) return false;
        if (tutCategory != null ? !tutCategory.equals(that.tutCategory) : that.tutCategory != null) return false;
        if (tutSubcategory != null ? !tutSubcategory.equals(that.tutSubcategory) : that.tutSubcategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (tutDescription != null ? tutDescription.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (techList != null ? techList.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (codeLink != null ? codeLink.hashCode() : 0);
        result = 31 * result + (codeNotes != null ? codeNotes.hashCode() : 0);
        result = 31 * result + (tutReference != null ? tutReference.hashCode() : 0);
        result = 31 * result + (tutCategory != null ? tutCategory.hashCode() : 0);
        result = 31 * result + (tutSubcategory != null ? tutSubcategory.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tutorialsTableByTutId")
    public Collection<TutStepsModuleMappingTblEntity> getTutStepsModuleMappingTblsById() {
        return tutStepsModuleMappingTblsById;
    }

    public void setTutStepsModuleMappingTblsById(Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById) {
        this.tutStepsModuleMappingTblsById = tutStepsModuleMappingTblsById;
    }

    @OneToMany(mappedBy = "tutorialTableByTutId")
    @OrderBy(value = "moduleOrder ASC")
    public Collection<TutorialModuleTblEntity> getTutorialModuleTblEntities() {
        return tutorialModuleTblEntities;
    }

    public void setTutorialModuleTblEntities(Collection<TutorialModuleTblEntity> tutorialModuleTblEntities) {
        this.tutorialModuleTblEntities = tutorialModuleTblEntities;
    }
    @OneToMany
    @JoinColumn(name="generic_id")
    public Collection<FaqTable> getFaqs() {
        return faqs;
    }

    public void setFaqs(Collection<FaqTable> faqs) {
        this.faqs = faqs;
    }
    @OneToMany
    @JoinColumn(name="generic_id")
    public Collection<RelatedLinkTable> getRelated() {
        return related;
    }

    public void setRelated(Collection<RelatedLinkTable> related) {
        this.related = related;
    }
}
