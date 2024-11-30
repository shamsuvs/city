package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smashplus.cityxplor.domain.SpecialityTblEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class EstablishmentDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;


    @JsonProperty("district")
    private String district;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("website")
    private String website;
    @JsonProperty("youtubeurl")
    private String youtubeUrl;

    @JsonProperty("about")
    private String about;

    @JsonProperty("features")
    private String features;

    @JsonProperty("image1")
    private String image1;

    @JsonProperty("image2")
    private String image2;

    @JsonProperty("image3")
    private String image3;

    @JsonProperty("teaser")
    private String teaser;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("category")
    private String category;
    @JsonProperty("est_category")
    private String estCategory;

    @JsonProperty("subcategory")
    private String subCategory;

    @JsonProperty("likes")
    private String likes;

    @JsonProperty("is_active")
    private String isActive;

    @JsonProperty("special_note")
    private String specialNote;

    @JsonProperty("un_seo_id")
    private String uniqueSEOId;
    private List<DoctorDTO> doctors=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getImage1() {
        return image1;
    }

    public String getImage3() {
        return image3;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getTeaser() {
        return teaser;
    }

    public String getEstCategory() {
        return estCategory;
    }

    public void setEstCategory(String estCategory) {
        this.estCategory = estCategory;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public List<DoctorDTO> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorDTO> doctors) {
        this.doctors = doctors;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getUniqueSEOId() {
        return uniqueSEOId;
    }

    public void setUniqueSEOId(String uniqueSEOId) {
        this.uniqueSEOId = uniqueSEOId;
    }
}
