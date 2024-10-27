package com.smashplus.cityxplor.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "listing_entity_mapping")
public class ListingEntityMappingEntity {
    private String idMapping;
    private String listId;
    private Integer entityId;
    private ListingTblEntity listingTblByListId;
    private EntityDTO entityByEntityId;

    @Id
    @Column(name = "idMapping")
    public String getIdMapping() {
        return idMapping;
    }

    public void setIdMapping(String idMapping) {
        this.idMapping = idMapping;
    }

    @Basic
    @Column(name = "listId")
    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "entityId")
    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListingEntityMappingEntity that = (ListingEntityMappingEntity) o;

        if (idMapping != null ? !idMapping.equals(that.idMapping) : that.idMapping != null) return false;
        if (listId != null ? !listId.equals(that.listId) : that.listId != null) return false;
        if (entityId != null ? !entityId.equals(that.entityId) : that.entityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMapping != null ? idMapping.hashCode() : 0;
        result = 31 * result + (listId != null ? listId.hashCode() : 0);
        result = 31 * result + (entityId != null ? entityId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "listId", referencedColumnName = "listid", nullable = false, insertable=false, updatable=false)
    public ListingTblEntity getListingTblByListId() {
        return listingTblByListId;
    }

    public void setListingTblByListId(ListingTblEntity listingTblByListId) {
        this.listingTblByListId = listingTblByListId;
    }

    @ManyToOne
    @JoinColumn(name = "entityId", referencedColumnName = "ENT_ID", nullable = false, insertable=false, updatable=false)
    public EntityDTO getEntityByEntityId() {
        return entityByEntityId;
    }

    public void setEntityByEntityId(EntityDTO entityByEntityId) {
        this.entityByEntityId = entityByEntityId;
    }
}
