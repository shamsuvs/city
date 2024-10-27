package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "int_listing_qtn_mapping", schema = "sp1", catalog = "")
public class IntListingQtnMappingEntity {
    private int idMapping;
    private String intListId;
    private Integer qtnId;
    private InterviewQtnListingTblEntity interviewQtnListingTblByIntListId;
    private InterviewQuestionTblEntity interviewQuestionTblByQtnId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mapping")
    public int getIdMapping() {
        return idMapping;
    }

    public void setIdMapping(int idMapping) {
        this.idMapping = idMapping;
    }

    @Basic
    @Column(name = "int_list_Id")
    public String getIntListId() {
        return intListId;
    }

    public void setIntListId(String intListId) {
        this.intListId = intListId;
    }

    @Basic
    @Column(name = "qtn_id")
    public Integer getQtnId() {
        return qtnId;
    }

    public void setQtnId(Integer qtnId) {
        this.qtnId = qtnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntListingQtnMappingEntity that = (IntListingQtnMappingEntity) o;

        if (idMapping != that.idMapping) return false;
        if (intListId != null ? !intListId.equals(that.intListId) : that.intListId != null) return false;
        if (qtnId != null ? !qtnId.equals(that.qtnId) : that.qtnId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMapping;
        result = 31 * result + (intListId != null ? intListId.hashCode() : 0);
        result = 31 * result + (qtnId != null ? qtnId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "int_list_Id", referencedColumnName = "id",insertable = false,updatable = false)
    public InterviewQtnListingTblEntity getInterviewQtnListingTblByIntListId() {
        return interviewQtnListingTblByIntListId;
    }

    public void setInterviewQtnListingTblByIntListId(InterviewQtnListingTblEntity interviewQtnListingTblByIntListId) {
        this.interviewQtnListingTblByIntListId = interviewQtnListingTblByIntListId;
    }

    @ManyToOne
    @JoinColumn(name = "qtn_id", referencedColumnName = "id",insertable = false,updatable = false)
    public InterviewQuestionTblEntity getInterviewQuestionTblByQtnId() {
        return interviewQuestionTblByQtnId;
    }

    public void setInterviewQuestionTblByQtnId(InterviewQuestionTblEntity interviewQuestionTblByQtnId) {
        this.interviewQuestionTblByQtnId = interviewQuestionTblByQtnId;
    }
}
