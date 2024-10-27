package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "interview_question_tbl", schema = "sp1", catalog = "")
public class InterviewQuestionTblEntity {
    private int id;
    private String question;
    private String shortAnswer;
    private String answer;
    private String author = "shams";
    private String tags;
    private String category;
    private String subcategory;
    private String ytCode;
    private String complexity;
    private String technology;
    private String type;//for future
    private Date modifyDate;
    private Integer likes;
    private Integer entityId;
    private String image;
    private String topic;
    private Collection<IntListingQtnMappingEntity> intListingQtnMappingsById;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "short_answer")
    public String getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(String shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
    @Column(name = "complexity")
    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "entity_id")
    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewQuestionTblEntity that = (InterviewQuestionTblEntity) o;

        if (id != that.id) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (shortAnswer != null ? !shortAnswer.equals(that.shortAnswer) : that.shortAnswer != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subcategory != null ? !subcategory.equals(that.subcategory) : that.subcategory != null) return false;
        if (ytCode != null ? !ytCode.equals(that.ytCode) : that.ytCode != null) return false;
        if (complexity != null ? !complexity.equals(that.complexity) : that.complexity != null) return false;
        if (technology != null ? !technology.equals(that.technology) : that.technology != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (entityId != null ? !entityId.equals(that.entityId) : that.entityId != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (shortAnswer != null ? shortAnswer.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subcategory != null ? subcategory.hashCode() : 0);
        result = 31 * result + (ytCode != null ? ytCode.hashCode() : 0);
        result = 31 * result + (complexity != null ? complexity.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (entityId != null ? entityId.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "interviewQuestionTblByQtnId")
    public Collection<IntListingQtnMappingEntity> getIntListingQtnMappingsById() {
        return intListingQtnMappingsById;
    }

    public void setIntListingQtnMappingsById(Collection<IntListingQtnMappingEntity> intListingQtnMappingsById) {
        this.intListingQtnMappingsById = intListingQtnMappingsById;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
