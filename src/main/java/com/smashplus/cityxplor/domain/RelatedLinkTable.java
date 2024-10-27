package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "related_link_table")
public class RelatedLinkTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "link_text", length = 400)
    private String linkText;
    @Column(name = "generic_id", length = 400)
    private String genericId;

    @ManyToOne
    @JoinColumn(name = "weblog_id")
    private Weblog weblog;

    @Column(name = "link", length = 400)
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public Weblog getWeblog() {
        return weblog;
    }

    public void setWeblog(Weblog weblog) {
        this.weblog = weblog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenericId() {
        return genericId;
    }

    public void setGenericId(String genericId) {
        this.genericId = genericId;
    }
}
