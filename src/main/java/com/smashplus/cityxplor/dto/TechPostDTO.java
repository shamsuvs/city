package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TechPostDTO {


    @JsonProperty("post_id")
    String postId;

    long soPostID;
    @JsonProperty("post_title")
    String title;
    @JsonProperty("enh_post_title")
    String enhTitle;
    @JsonProperty("post_teaser")
    String postTeaser;

    @JsonProperty("cur_answer_title")
    String curatedAnswerTitle;

    @JsonProperty("primary_tag")
    String primaryTag;
    @JsonProperty("secondary_tag")
    String secondaryTag;
    @JsonProperty("sv_curated_qtn")
    String postBody;
    String primaryResponseId;
    String primaryResponseBody;
    @JsonProperty("smash_void_curated_answer")
    String curatedAnswer;
    String category;
    String subCategory;
    String soUrl;
    @JsonProperty("ver_rel_answer")
    String isVersionSpecAnswer;
    @JsonProperty("ver_specifier")
    String version;
    @JsonProperty("ver_spec_answer")
    String versionRelatedAns;

    @JsonProperty("post_image_url")
    String image;
    @JsonProperty("created_date")
    Date createdDate;
    @JsonProperty("modified_date")
    Date modifiedDate;
    @JsonProperty("created_by")
    String createdBy;
    @JsonProperty("youtube_video_url")
    String youtubeVideo;

    List<String> tags;

    long viewCount;

    public TechPostDTO() {
    }

    public TechPostDTO(String title) {
        this.title = title;
    }

    public long getSoPostID() {
        return soPostID;
    }

    public void setSoPostID(long soPostID) {
        this.soPostID = soPostID;
    }

    //out
    String status;
    String message;

    public TechPostDTO(String postId, String title, String primaryTag, String postBody, String primaryResponseId, String primaryResponseBody) {
        this.postId = postId;
        this.title = title;
        this.primaryTag = primaryTag;
        this.postBody = postBody;
        this.primaryResponseId = primaryResponseId;
        this.primaryResponseBody = primaryResponseBody;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryTag() {
        return primaryTag;
    }

    public void setPrimaryTag(String primaryTag) {
        this.primaryTag = primaryTag;
        setTags(primaryTag);
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPrimaryResponseId() {
        return primaryResponseId;
    }

    public void setPrimaryResponseId(String primaryResponseId) {
        this.primaryResponseId = primaryResponseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public String getPrimaryResponseBody() {
        return primaryResponseBody;
    }

    public void setPrimaryResponseBody(String primaryResponseBody) {
        this.primaryResponseBody = primaryResponseBody;
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

    public String getSoUrl() {
        return soUrl;
    }

    public void setSoUrl(String soUrl) {
        this.soUrl = soUrl;
    }

    public String getSecondaryTag() {
        return secondaryTag;
    }

    public void setSecondaryTag(String secondaryTag) {
        this.secondaryTag = secondaryTag;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public String getCuratedAnswer() {
        return curatedAnswer;
    }

    public void setCuratedAnswer(String curatedAnswer) {
        this.curatedAnswer = curatedAnswer;
    }

    public String getIsVersionSpecAnswer() {
        return isVersionSpecAnswer;
    }

    public void setIsVersionSpecAnswer(String isVersionSpecAnswer) {
        this.isVersionSpecAnswer = isVersionSpecAnswer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionRelatedAns() {
        return versionRelatedAns;
    }

    public void setVersionRelatedAns(String versionRelatedAns) {
        this.versionRelatedAns = versionRelatedAns;
    }

    public String getEnhTitle() {
        return enhTitle;
    }

    public void setEnhTitle(String enhTitle) {
        this.enhTitle = enhTitle;
    }

    public String getPostTeaser() {
        return postTeaser;
    }

    public void setPostTeaser(String postTeaser) {
        this.postTeaser = postTeaser;
    }

    public String getCuratedAnswerTitle() {
        return curatedAnswerTitle;
    }

    public void setCuratedAnswerTitle(String curatedAnswerTitle) {
        this.curatedAnswerTitle = curatedAnswerTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(String tags) {


        this.tags = Arrays.asList(tags.split(":"));
    }
}
