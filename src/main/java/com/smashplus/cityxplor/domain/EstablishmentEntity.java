package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "establishment", schema = "sp1", catalog = "")
public class EstablishmentEntity {
    private int id;
    private String estName;
    private String address;
    private String email;
    private String mobile;
    private String phone;
    private String district;
    private Integer city;
    private String state;
    private String country;
    private String speciality;
    private String about;
    private String teaser;
    private String features;
    private String specialNote;
    private String image1;
    private String image2;
    private String image3;
    private String logo;
    private String thumbnail;
    private String website;
    private String category;
    private String subCategory;
    private String type;
    private String googleMapUrl;
    private String youtubeUrl;
    private String cost;
    private String vivo;
    private String tags;
    private Integer likes;
    private boolean publish=false;
    private String url;
    private CityTableEntity cityTableByCity;
    private Collection<SpecialityTblEntity> specialityTblsById=new ArrayList<>();

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
    @Column(name = "est_name")
    public String getEstName() {
        return estName;
    }

    public void setEstName(String estName) {
        this.estName = estName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city")
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Basic
    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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
    @Column(name = "features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Basic
    @Column(name = "special_note")
    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
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
    @Column(name = "image2")
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "image3")
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
    @Column(name = "sub_category")
    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
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
    @Column(name = "google_map_url")
    public String getGoogleMapUrl() {
        return googleMapUrl;
    }

    public void setGoogleMapUrl(String googleMapUrl) {
        this.googleMapUrl = googleMapUrl;
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
    @Column(name = "cost")
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "vivo")
    public String getVivo() {
        return vivo;
    }

    public void setVivo(String vivo) {
        this.vivo = vivo;
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
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstablishmentEntity that = (EstablishmentEntity) o;

        if (id != that.id) return false;
        if (estName != null ? !estName.equals(that.estName) : that.estName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (features != null ? !features.equals(that.features) : that.features != null) return false;
        if (specialNote != null ? !specialNote.equals(that.specialNote) : that.specialNote != null) return false;
        if (image1 != null ? !image1.equals(that.image1) : that.image1 != null) return false;
        if (image2 != null ? !image2.equals(that.image2) : that.image2 != null) return false;
        if (image3 != null ? !image3.equals(that.image3) : that.image3 != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subCategory != null ? !subCategory.equals(that.subCategory) : that.subCategory != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (googleMapUrl != null ? !googleMapUrl.equals(that.googleMapUrl) : that.googleMapUrl != null) return false;
        if (youtubeUrl != null ? !youtubeUrl.equals(that.youtubeUrl) : that.youtubeUrl != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (vivo != null ? !vivo.equals(that.vivo) : that.vivo != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (estName != null ? estName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        result = 31 * result + (specialNote != null ? specialNote.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (image2 != null ? image2.hashCode() : 0);
        result = 31 * result + (image3 != null ? image3.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subCategory != null ? subCategory.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (googleMapUrl != null ? googleMapUrl.hashCode() : 0);
        result = 31 * result + (youtubeUrl != null ? youtubeUrl.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (vivo != null ? vivo.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id",updatable = false, insertable = false)
    public CityTableEntity getCityTableByCity() {
        return cityTableByCity;
    }

    public void setCityTableByCity(CityTableEntity cityTableByCity) {
        this.cityTableByCity = cityTableByCity;
    }

    @OneToMany(mappedBy = "establishmentByEstabId")
    public Collection<SpecialityTblEntity> getSpecialityTblsById() {
        return specialityTblsById;
    }

    public void setSpecialityTblsById(Collection<SpecialityTblEntity> specialityTblsById) {
        this.specialityTblsById = specialityTblsById;
    }
}
