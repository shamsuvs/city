package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tut_steps_module_mapping_tbl", schema = "sp1" )
public class TutStepsModuleMappingTblEntity {
    private String tutId;
    private String moduleId;
    private Integer stepId;
    private int mapTblId;
    private String stepOrder;
    private TutorialsTableEntity tutorialsTableByTutId;
    private TutorialModuleTblEntity tutorialModuleTblByModuleId;
    private TutorialStepsTblEntity tutorialStepsTblByStepId;

    @Basic
    @Column(name = "tut_id")
    public String getTutId() {
        return tutId;
    }

    public void setTutId(String tutId) {
        this.tutId = tutId;
    }

    @Basic
    @Column(name = "module_id")
    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "step_id")
    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }
    @Id
    @Basic
    @Column(name = "map_tbl_id")
    public int getMapTblId() {
        return mapTblId;
    }

    public void setMapTblId(int mapTblId) {
        this.mapTblId = mapTblId;
    }

    @Basic
    @Column(name = "chapter_order")
    public String getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(String chapterOrder) {
        this.stepOrder = chapterOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutStepsModuleMappingTblEntity that = (TutStepsModuleMappingTblEntity) o;

        if (mapTblId != that.mapTblId) return false;
        if (tutId != null ? !tutId.equals(that.tutId) : that.tutId != null) return false;
        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (stepId != null ? !stepId.equals(that.stepId) : that.stepId != null) return false;
        if (stepOrder != null ? !stepOrder.equals(that.stepOrder) : that.stepOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tutId != null ? tutId.hashCode() : 0;
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        result = 31 * result + (stepId != null ? stepId.hashCode() : 0);
        result = 31 * result + mapTblId;
        result = 31 * result + (stepOrder != null ? stepOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "tut_id", referencedColumnName = "id",updatable = false,insertable = false)
    public TutorialsTableEntity getTutorialsTableByTutId() {
        return tutorialsTableByTutId;
    }

    public void setTutorialsTableByTutId(TutorialsTableEntity tutorialsTableByTutId) {
        this.tutorialsTableByTutId = tutorialsTableByTutId;
    }

    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id", updatable = false,insertable = false)
    public TutorialModuleTblEntity getTutorialModuleTblByModuleId() {
        return tutorialModuleTblByModuleId;
    }

    public void setTutorialModuleTblByModuleId(TutorialModuleTblEntity tutorialModuleTblByModuleId) {
        this.tutorialModuleTblByModuleId = tutorialModuleTblByModuleId;
    }

    @ManyToOne
    @JoinColumn(name = "step_id", referencedColumnName = "id" ,updatable = false,insertable = false)
    public TutorialStepsTblEntity getTutorialStepsTblByStepId() {
        return tutorialStepsTblByStepId;
    }

    public void setTutorialStepsTblByStepId(TutorialStepsTblEntity tutorialStepsTblByStepId) {
        this.tutorialStepsTblByStepId = tutorialStepsTblByStepId;
    }
}
