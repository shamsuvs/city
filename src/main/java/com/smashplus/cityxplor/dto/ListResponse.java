package com.smashplus.cityxplor.dto;

import java.util.List;


public class ListResponse {
    public List<ListCuratorDTO> items;

    public List<ListCuratorDTO> getItems() {
        return items;
    }

    public void setItems(List<ListCuratorDTO> items) {
        this.items = items;
    }
}
