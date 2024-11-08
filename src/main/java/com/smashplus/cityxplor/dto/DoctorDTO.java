package com.smashplus.cityxplor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smashplus.cityxplor.domain.EstablishmentEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class DoctorDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("speciality")
    private String speciality;
    @JsonProperty("speciality_short_code")
    private String specialityShortCode;
    @JsonProperty("qualification")
    private String qualification;
    @JsonProperty("establishmentdto")
    private List<EstablishmentDTO> establishmentDTO=new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialityShortCode() {
        return specialityShortCode;
    }

    public void setSpecialityShortCode(String specialityShortCode) {
        this.specialityShortCode = specialityShortCode;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<EstablishmentDTO> getEstablishmentDTO() {
        return establishmentDTO;
    }

    public void setEstablishmentDTO(List<EstablishmentDTO> establishmentDTO) {
        this.establishmentDTO = establishmentDTO;
    }
}
