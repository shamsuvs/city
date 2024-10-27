package com.smashplus.cityxplor.dto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ProcessedEntityDTO extends EntityDTO {

    private List<String> tagsList;

    private List<String> featureList;

    private List<String> specialities;


    public ProcessedEntityDTO() {

    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList() {
        this.tagsList= Arrays.asList(this.getTags().split(","));

    }

    public List<String> getFeatureList() {
        return featureList;
    }

    public void setTagsList(LinkedList<String> tagsList) {
        this.tagsList = tagsList;
    }

    public void setFeatureList(List<String> featureList) {
        this.featureList = featureList;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public void setFeatureList() {
        this.featureList= Arrays.asList(this.getFeatures().split(","));
    }


    public List<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities() {
        this.specialities= Arrays.asList(this.getSpeciality().split(","));
    }

}
