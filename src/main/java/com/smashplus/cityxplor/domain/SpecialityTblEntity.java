package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "speciality_tbl", schema = "sp1", catalog = "")
public class SpecialityTblEntity {
    private int id;
    private String name;
    private String nameMal;
    private String degree;
    private String speciality;
    private Integer likes;
    private boolean active;
    private String thumbNail;
    private Integer estabId;
    private EstablishmentEntity establishmentByEstabId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name_mal")
    public String getNameMal() {
        return nameMal;
    }

    public void setNameMal(String nameMal) {
        this.nameMal = nameMal;
    }

    @Basic
    @Column(name = "degree")
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
    @Column(name = "estab_id")
    public Integer getEstabId() {
        return estabId;
    }

    public void setEstabId(Integer estabId) {
        this.estabId = estabId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialityTblEntity that = (SpecialityTblEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nameMal != null ? !nameMal.equals(that.nameMal) : that.nameMal != null) return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (thumbNail != null ? !thumbNail.equals(that.thumbNail) : that.thumbNail != null) return false;
        if (estabId != null ? !estabId.equals(that.estabId) : that.estabId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nameMal != null ? nameMal.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (thumbNail != null ? thumbNail.hashCode() : 0);
        result = 31 * result + (estabId != null ? estabId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "estab_id", referencedColumnName = "id",updatable = false,insertable = false)
    public EstablishmentEntity getEstablishmentByEstabId() {
        return establishmentByEstabId;
    }

    public void setEstablishmentByEstabId(EstablishmentEntity establishmentByEstabId) {
        this.establishmentByEstabId = establishmentByEstabId;
    }
}
