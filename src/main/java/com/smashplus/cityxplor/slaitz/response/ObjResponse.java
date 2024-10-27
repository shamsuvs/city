package com.smashplus.cityxplor.slaitz.response;

import com.smashplus.cityxplor.slaitz.dto.EntityDTO;

import java.util.List;

public class ObjResponse {
    public List<EntityDTO> items;

    public List<EntityDTO> getItems() {
        return items;
    }

    public void setItems(List<EntityDTO> items) {
        this.items = items;
    }
}
