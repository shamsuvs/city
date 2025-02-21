package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TouristAttractionDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("teaser")
    private String teaser;

    @JsonProperty("description")
    private String description;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("category")
    private String category;

    @JsonProperty("features")
    private String features;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("entry_fee")
    private String entryFee;

    @JsonProperty("opening_hours")
    private String openingHours;

    @JsonProperty("closing_day")
    private String closingDay;

    @JsonProperty("best_time_to_visit")
    private String bestTimeToVisit;

    @JsonProperty("image1")
    private String image1;

    @JsonProperty("image2")
    private String image2;

    @JsonProperty("image3")
    private String image3;

    @JsonProperty("youtube_url")
    private String youtubeUrl;

    @JsonProperty("contact_number")
    private String contactNumber;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("useo_url")
    private String useoUrl;

    @JsonProperty("average_rating")
    private String averageRating;

    @JsonProperty("visitor_count")
    private String visitorCount;

    @JsonProperty("note")
    private String note;

    @JsonProperty("created_dated")
    private String createdDate;

    @JsonProperty("create_by")
    private String createdBy;

    @JsonProperty("author")
    private String author;

    @JsonProperty("modified_date")
    private String modifiedDate;

    @JsonProperty("status")
    private String status;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTeaser() { return teaser; }
    public void setTeaser(String teaser) { this.teaser = teaser; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getFeatures() { return features; }
    public void setFeatures(String features) { this.features = features; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public String getEntryFee() { return entryFee; }
    public void setEntryFee(String entryFee) { this.entryFee = entryFee; }

    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }

    public String getClosingDay() { return closingDay; }
    public void setClosingDay(String closingDay) { this.closingDay = closingDay; }

    public String getBestTimeToVisit() { return bestTimeToVisit; }
    public void setBestTimeToVisit(String bestTimeToVisit) { this.bestTimeToVisit = bestTimeToVisit; }

    public String getImage1() { return image1; }
    public void setImage1(String image1) { this.image1 = image1; }

    public String getImage2() { return image2; }
    public void setImage2(String image2) { this.image2 = image2; }

    public String getImage3() { return image3; }
    public void setImage3(String image3) { this.image3 = image3; }

    public String getYoutubeUrl() { return youtubeUrl; }
    public void setYoutubeUrl(String youtubeUrl) { this.youtubeUrl = youtubeUrl; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getWebsiteUrl() { return websiteUrl; }
    public void setWebsiteUrl(String websiteUrl) { this.websiteUrl = websiteUrl; }

    public String getUseoUrl() { return useoUrl; }
    public void setUseoUrl(String useoUrl) { this.useoUrl = useoUrl; }

    public String getAverageRating() { return averageRating; }
    public void setAverageRating(String averageRating) { this.averageRating = averageRating; }

    public String getVisitorCount() { return visitorCount; }
    public void setVisitorCount(String visitorCount) { this.visitorCount = visitorCount; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(String modifiedDate) { this.modifiedDate = modifiedDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
