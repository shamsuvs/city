package com.smashplus.cityxplor.dto;

import java.util.List;

public class SiteMapResponse {
    public List<HousekeepingDTO> items;

    public List<HousekeepingDTO> getItems() {
        return items;
    }

    public void setItems(List<HousekeepingDTO> items) {
        this.items = items;
    }
}
