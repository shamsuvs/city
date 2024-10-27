package com.smashplus.cityxplor.domain;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tutorial_module_tbl", schema = "sp1", catalog = "")
public class TutorialModuleTblEntity {
    private String id;
    private String title;
    private String teaser;
    private String iconImageLink;
    private String tutId;
    private Integer moduleOrder;
    private Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById;
    private TutorialsTableEntity tutorialTableByTutId;
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "icon_image_link")
    public String getIconImageLink() {
        return iconImageLink;
    }

    public void setIconImageLink(String iconImageLink) {
        this.iconImageLink = iconImageLink;
    }

    @Basic
    @Column(name = "tut_id")
    public String getTutId() {
        return tutId;
    }

    public void setTutId(String tutId) {
        this.tutId = tutId;
    }

    @Basic
    @Column(name = "module_order")
    public Integer getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(Integer moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorialModuleTblEntity that = (TutorialModuleTblEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (teaser != null ? !teaser.equals(that.teaser) : that.teaser != null) return false;
        if (iconImageLink != null ? !iconImageLink.equals(that.iconImageLink) : that.iconImageLink != null)
            return false;
        if (tutId != null ? !tutId.equals(that.tutId) : that.tutId != null) return false;
        if (moduleOrder != null ? !moduleOrder.equals(that.moduleOrder) : that.moduleOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (iconImageLink != null ? iconImageLink.hashCode() : 0);
        result = 31 * result + (tutId != null ? tutId.hashCode() : 0);
        result = 31 * result + (moduleOrder != null ? moduleOrder.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tutorialModuleTblByModuleId")
    @OrderBy(value = "stepOrder ASC")
    public Collection<TutStepsModuleMappingTblEntity> getTutStepsModuleMappingTblsById() {
        return tutStepsModuleMappingTblsById;
    }

    public void setTutStepsModuleMappingTblsById(Collection<TutStepsModuleMappingTblEntity> tutStepsModuleMappingTblsById) {
        this.tutStepsModuleMappingTblsById = tutStepsModuleMappingTblsById;
    }

    @ManyToOne
    @JoinColumn(name = "tut_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public TutorialsTableEntity getTutorialTableByTutId() {
        return tutorialTableByTutId;
    }

    public void setTutorialTableByTutId(TutorialsTableEntity tutorialTableByTutId) {
        this.tutorialTableByTutId = tutorialTableByTutId;
    }
}
