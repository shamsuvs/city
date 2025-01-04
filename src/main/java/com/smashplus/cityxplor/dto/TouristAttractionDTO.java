package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TouristAttractionDTO {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String  name;

    @JsonProperty("teaser")
    String teaser;

    @JsonProperty("description")
    String description;

    @JsonProperty("address")
    String address;

    @JsonProperty("city")
    String city;

    @JsonProperty("state")
    String state;

    @JsonProperty("country")
    String country;

    //@JsonProperty("location_map")
    //;

    @JsonProperty("category")
    String category;

    @JsonProperty("features")
    String features;

    @JsonProperty("tags")
    String tags;

    @JsonProperty("entry_fee")
    String entryFee;

    @JsonProperty("opening_hours")
    String openingHours;

    @JsonProperty("closing_day")
    String closingDay;

    @JsonProperty("best_time_to_visit")
    String bestTimeToVisit;

    @JsonProperty("image1")
    String image1;

    @JsonProperty("image2")
    String image2;

    @JsonProperty("image3")
    String image3;

    @JsonProperty("youtube_url")
    String youtubeUrl;

    @JsonProperty("contact_number")
    String contactNumber;

    @JsonProperty("website_url")
    String websiteUrl;

    @JsonProperty("useo_url")
    String useoUrl;

    @JsonProperty("average_rating")
    String averageRating;

    @JsonProperty("visitor_count")
    String visitorCount;

    @JsonProperty("note")
    String note;

    @JsonProperty("created_dated")
    String createdDate;

    @JsonProperty("create_by")
    String createdBy;

    @JsonProperty("author")
    String author;

    @JsonProperty("modified_date")
    String modifiedDate;

    @JsonProperty("status")
    String status;

    public int getId(){

        return id;
    }

    public void setId(){

        this.id = id;
    }

    public String getName(){

        return name;
    }

    public void setName(){

        this.name = name;
    }

    public String getTeaser(){

        return teaser;
    }

    public void setTeaser(){

        this.teaser = teaser;
    }

    public String getDescription(){

        return description;
    }

    public void setDescription(){
        this.description = description;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(){
        this.address = address;
    }

    public String getCity(){
        return city;
    }

    public void setCity(){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(){
        this.state = state;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(){
        this.country = country;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(){
        this.category = category;
    }

    public String getFeatures(){
        return features;
    }

    public void setFeatures(){
        this.features = features;
    }

    public String getTags(){
        return tags;
    }

    public void setTags(){
        this.tags = tags;
    }

    public String getEntryFee(){
        return entryFee;
    }

    public void setEntryFee(){
        this.entryFee = entryFee;
    }

    public String getOpeningHours(){
        return openingHours;
    }

    public void setOpeningHours(){
        this.openingHours = openingHours;
    }

    public String getClosingDay(){
        return closingDay;
    }

    public void setClosingDay(){
        this.closingDay = closingDay;
    }

    public String getBestTimeToVisit(){
        return bestTimeToVisit;
    }

    public void setBestTimeToVisit(){
        this.bestTimeToVisit = bestTimeToVisit;
    }

    public String getImage1(){
        return image1;
    }

    public void setImage1(){
        this.image1 = image1;
    }

    public String getImage2(){
        return image2;
    }

    public void setImage2(){
        this.image2 = image2;
    }

    public String getImage3(){
        return image3;
    }

    public void setImage3(){
        this.image3 = image3;
    }

    public String getYoutubeUrl(){
        return youtubeUrl;
    }

    public void setYoutubeUrl(){
        this.youtubeUrl = youtubeUrl;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(){
        this.contactNumber = contactNumber;
    }

    public String getWebsiteUrl(){
        return websiteUrl;
    }

    public void setWebsiteUrl(){
        this.websiteUrl = websiteUrl;
    }

    public String getUseoUrl(){
        return useoUrl;
    }

    public void setUseoUrl(){
        this.useoUrl = useoUrl;
    }

    public String getAverageRating(){
        return averageRating;
    }

    public void setAverageRating(){
        this.averageRating = averageRating;
    }

    public String getVisitorCount(){
        return visitorCount;
    }

    public void setVisitorCount(){
        this.visitorCount = visitorCount;
    }

    public String getNote(){
        return note;
    }

    public void setNote(){
        this.note = note;
    }

    public String getCreatedDate(){
        return createdDate;
    }

    public void setCreatedDate(){
        this.createdDate = createdDate;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public void setCreatedBy(){
        this.createdBy = createdBy;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(){
        this.author = author;
    }

    public String getModifiedDate(){
        return modifiedDate;
    }

    public void setModifiedDate(){
        this.modifiedDate = modifiedDate;
    }
}
