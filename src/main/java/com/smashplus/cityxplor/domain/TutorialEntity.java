package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "example_series_table")

public class TutorialEntity {
    public TutorialEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "teaser", length = 400)
    private String teaser;

    @Column(name = "example_description", length = 2000)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
