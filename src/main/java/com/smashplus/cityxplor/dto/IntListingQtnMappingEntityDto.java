package com.smashplus.cityxplor.dto;

import java.io.Serializable;
import java.util.Objects;

public class IntListingQtnMappingEntityDto implements Serializable {
    private final int idMapping;
    private final String intListId;
    private final Integer qtnId;

    public IntListingQtnMappingEntityDto(int idMapping, String intListId, Integer qtnId) {
        this.idMapping = idMapping;
        this.intListId = intListId;
        this.qtnId = qtnId;
    }

    public int getIdMapping() {
        return idMapping;
    }

    public String getIntListId() {
        return intListId;
    }

    public Integer getQtnId() {
        return qtnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntListingQtnMappingEntityDto entity = (IntListingQtnMappingEntityDto) o;
        return Objects.equals(this.idMapping, entity.idMapping) &&
                Objects.equals(this.intListId, entity.intListId) &&
                Objects.equals(this.qtnId, entity.qtnId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMapping, intListId, qtnId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idMapping = " + idMapping + ", " +
                "intListId = " + intListId + ", " +
                "qtnId = " + qtnId + ")";
    }
}
