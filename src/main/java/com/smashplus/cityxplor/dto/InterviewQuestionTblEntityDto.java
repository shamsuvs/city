package com.smashplus.cityxplor.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class InterviewQuestionTblEntityDto implements Serializable {
    private final int id;
    private final String question;
    private final String shortAnswer;
    private final String answer;
    private final String author;
    private final String tags;
    private final String category;
    private final String subcategory;
    private final String ytCode;
    private final String complexity;
    private final String technology;
    private final String type;
    private final Date modifyDate;
    private final Integer likes;
    private final Integer entityId;
    private final String image;

    public InterviewQuestionTblEntityDto(int id, String question, String shortAnswer, String answer, String author, String tags, String category, String subcategory, String ytCode, String complexity, String technology, String type, Date modifyDate, Integer likes, Integer entityId, String image) {
        this.id = id;
        this.question = question;
        this.shortAnswer = shortAnswer;
        this.answer = answer;
        this.author = author;
        this.tags = tags;
        this.category = category;
        this.subcategory = subcategory;
        this.ytCode = ytCode;
        this.complexity = complexity;
        this.technology = technology;
        this.type = type;
        this.modifyDate = modifyDate;
        this.likes = likes;
        this.entityId = entityId;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getShortAnswer() {
        return shortAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAuthor() {
        return author;
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

    public String getComplexity() {
        return complexity;
    }

    public String getTechnology() {
        return technology;
    }

    public String getType() {
        return type;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQuestionTblEntityDto entity = (InterviewQuestionTblEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.question, entity.question) &&
                Objects.equals(this.shortAnswer, entity.shortAnswer) &&
                Objects.equals(this.answer, entity.answer) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.tags, entity.tags) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.subcategory, entity.subcategory) &&
                Objects.equals(this.ytCode, entity.ytCode) &&
                Objects.equals(this.complexity, entity.complexity) &&
                Objects.equals(this.technology, entity.technology) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.modifyDate, entity.modifyDate) &&
                Objects.equals(this.likes, entity.likes) &&
                Objects.equals(this.entityId, entity.entityId) &&
                Objects.equals(this.image, entity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, shortAnswer, answer, author, tags, category, subcategory, ytCode, complexity, technology, type, modifyDate, likes, entityId, image);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "question = " + question + ", " +
                "shortAnswer = " + shortAnswer + ", " +
                "answer = " + answer + ", " +
                "author = " + author + ", " +
                "tags = " + tags + ", " +
                "category = " + category + ", " +
                "subcategory = " + subcategory + ", " +
                "ytCode = " + ytCode + ", " +
                "complexity = " + complexity + ", " +
                "technology = " + technology + ", " +
                "type = " + type + ", " +
                "modifyDate = " + modifyDate + ", " +
                "likes = " + likes + ", " +
                "entityId = " + entityId + ", " +
                "image = " + image + ")";
    }
}
