package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city_table", schema = "sp1", catalog = "")
public class CityTableEntity {
    private int id;
    private String cityCode;
    private String cityName;
    private String country;
    private String teaser;
    private String image1;
    private String thumbNail;
    private String description;
    private String blogPostId;
    private String blogId;
    private String youtubeVideoUrl;
    private Collection<EstablishmentEntity> establishmentsById;

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
    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
    @Column(name = "image1")
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "thumb_nail")
    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "blog_post_id")
    public String getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(String blogPostId) {
        this.blogPostId = blogPostId;
    }

    @Basic
    @Column(name = "blog_id")
    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    @Basic
    @Column(name = "youtube_video_url")
    public String getYoutubeVideoUrl() {
        return youtubeVideoUrl;
    }

    public void setYoutubeVideoUrl(String youtubeVideoUrl) {
        this.youtubeVideoUrl = youtubeVideoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityTableEntity that = (CityTableEntity) o;

        if (id != that.id) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (image1 != null ? !image1.equals(that.image1) : that.image1 != null) return false;
        if (thumbNail != null ? !thumbNail.equals(that.thumbNail) : that.thumbNail != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (blogPostId != null ? !blogPostId.equals(that.blogPostId) : that.blogPostId != null) return false;
        if (blogId != null ? !blogId.equals(that.blogId) : that.blogId != null) return false;
        if (youtubeVideoUrl != null ? !youtubeVideoUrl.equals(that.youtubeVideoUrl) : that.youtubeVideoUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (thumbNail != null ? thumbNail.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (blogPostId != null ? blogPostId.hashCode() : 0);
        result = 31 * result + (blogId != null ? blogId.hashCode() : 0);
        result = 31 * result + (youtubeVideoUrl != null ? youtubeVideoUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityTableByCity")
    public Collection<EstablishmentEntity> getEstablishmentsById() {
        return establishmentsById;
    }

    public void setEstablishmentsById(Collection<EstablishmentEntity> establishmentsById) {
        this.establishmentsById = establishmentsById;
    }
}
