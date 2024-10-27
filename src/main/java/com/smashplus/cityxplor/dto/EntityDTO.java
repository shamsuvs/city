package com.smashplus.cityxplor.dto;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "entity")
public class EntityDTO {
    private int entId;
    private String name;
    private String address;
    private String email;
    private String specialNote;
    private String mobile;
    private String phone;
    private String district;
    private String city;
    private String state;
    private String speciality;
    private String about;
    private String image;
    private String logo;
    private String website;
    private String image2;
    private String category;
    private String type;
    private String googleMapUrl;
    private String image1;
    private String teaser;
    private String youtubeUrl;
    //new
    private String features;

    private boolean publish;

    private String country;

    private String cost;

    private String vivo;

    private String tags;

    private int likes=0;




    private Collection<ListingEntityMappingEntity> listingEntityMappingsByEntId;


    public EntityDTO(int entId, String name, String address, String about, String teaser) {
        this.entId = entId;
        this.name = name;
        this.address = address;
        this.about = about;
        this.teaser = teaser;
    }

    public EntityDTO() {

    }

    @Id
    @Column(name = "ENT_ID")
    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
    @Column(name = "image1")
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
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
    @Column(name = "youtube_url")
    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
    @Basic
    @Column
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
    @Basic
    @Column
    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }
    @Basic
    @Column
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Basic
    @Column
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    @Basic
    @Column
    public String getVivo() {
        return vivo;
    }

    public void setVivo(String vivo) {
        this.vivo = vivo;
    }
    @Basic
    @Column
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityDTO that = (EntityDTO) o;

        if (entId != that.entId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (image2 != null ? !image2.equals(that.image2) : that.image2 != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (googleMapUrl != null ? !googleMapUrl.equals(that.googleMapUrl) : that.googleMapUrl != null) return false;
        if (image1 != null ? !image1.equals(that.image1) : that.image1 != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (youtubeUrl != null ? !youtubeUrl.equals(that.youtubeUrl) : that.youtubeUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = entId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (image2 != null ? image2.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (googleMapUrl != null ? googleMapUrl.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (youtubeUrl != null ? youtubeUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "entityByEntityId",fetch = FetchType.LAZY)
    public Collection<ListingEntityMappingEntity> getListingEntityMappingsByEntId() {
        return listingEntityMappingsByEntId;
    }

    public void setListingEntityMappingsByEntId(Collection<ListingEntityMappingEntity> listingEntityMappingsByEntId) {
        this.listingEntityMappingsByEntId = listingEntityMappingsByEntId;
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
    @Column
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
