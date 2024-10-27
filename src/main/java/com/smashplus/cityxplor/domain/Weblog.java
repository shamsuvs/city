package com.smashplus.cityxplor.domain;

import org.hibernate.Hibernate;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "weblog", indexes = {
        @Index(name = "idx_weblog_title", columnList = "title")
})
public class Weblog {
    public Weblog() {
    }

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "teaser", length = 400)
    private String teaser;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "authority")
    private String authority;

    @Column(name = "fact_1", length = 600)
    private String fact1;

    @Column(name = "fact_2", length = 600)
    private String fact2;

    @Column(name = "syllabus", length = 1000)
    private String syllabus;

    @Column(name = "languages", length = 400)
    private String languages;

    @Column(name = "type")
    private String type;

    @Column(name = "location", length = 300)
    private String location;

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "image", length = 300)
    private String image;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "weblog", cascade = CascadeType.ALL)
    private List<FaqTable> faqTables = new ArrayList<>();

    @OneToMany(mappedBy = "weblog", cascade = CascadeType.ALL)
    private List<RelatedLinkTable> relatedLinkTables = new ArrayList<>();

    @Column(name = "publish")
    private Boolean publish;

    @Column(name = "likes")
    private Integer like;

    public Weblog(Object o, Object o1) {
        this.id= (String) o;
        this.title= (String) o1;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RelatedLinkTable> getRelatedLinkTables() {
        return relatedLinkTables;
    }

    public void setRelatedLinkTables(List<RelatedLinkTable> relatedLinkTables) {
        this.relatedLinkTables = relatedLinkTables;
    }

    public List<FaqTable> getFaqTables() {
        return faqTables;
    }

    public void setFaqTables(List<FaqTable> faqTables) {
        this.faqTables = faqTables;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getFact2() {
        return fact2;
    }

    public void setFact2(String fact2) {
        this.fact2 = fact2;
    }

    public String getFact1() {
        return fact1;
    }

    public void setFact1(String fact1) {
        this.fact1 = fact1;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Weblog weblog = (Weblog) o;
        return id != null && Objects.equals(id, weblog.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
