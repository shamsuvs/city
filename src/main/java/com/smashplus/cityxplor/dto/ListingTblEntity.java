package com.smashplus.cityxplor.dto;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "listing_tbl")
public class ListingTblEntity {
    private String listid;
    private String title;
    private String teaser;
    private String postBody;
    private String image;
    private String thumbImg;
    private String author;
    private Date postDate;
    private String category;
    private String youtubeUrl;
    private String listSection;
    private Collection<ListingEntityMappingEntity> listingEntityMappingsByListid;

    @Id
    @Column(name = "listid")
    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
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
    @Column(name = "post_body")
    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
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
    @Column(name = "thumb_img")
    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg;
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
    @Column(name = "post_date")
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
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
    @Column(name = "youtube_url")
    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    @Basic
    @Column(name = "list_section")
    public String getListSection() {
        return listSection;
    }

    public void setListSection(String listSection) {
        this.listSection = listSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListingTblEntity that = (ListingTblEntity) o;

        if (listid != null ? !listid.equals(that.listid) : that.listid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (postBody != null ? !postBody.equals(that.postBody) : that.postBody != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (thumbImg != null ? !thumbImg.equals(that.thumbImg) : that.thumbImg != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (postDate != null ? !postDate.equals(that.postDate) : that.postDate != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (youtubeUrl != null ? !youtubeUrl.equals(that.youtubeUrl) : that.youtubeUrl != null) return false;
        if (listSection != null ? !listSection.equals(that.listSection) : that.listSection != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listid != null ? listid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (postBody != null ? postBody.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (thumbImg != null ? thumbImg.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (youtubeUrl != null ? youtubeUrl.hashCode() : 0);
        result = 31 * result + (listSection != null ? listSection.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "listingTblByListId")
    public Collection<ListingEntityMappingEntity> getListingEntityMappingsByListid() {
        return listingEntityMappingsByListid;
    }

    public void setListingEntityMappingsByListid(Collection<ListingEntityMappingEntity> listingEntityMappingsByListid) {
        this.listingEntityMappingsByListid = listingEntityMappingsByListid;
    }
}
