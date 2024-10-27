package com.smashplus.cityxplor.dto;

import java.util.List;

public class Response {
    public List<TechPostDTO> items;

    public List<TechPostDTO> getItems() {
        return items;
    }

    public void setItems(List<TechPostDTO> items) {
        this.items = items;
    }
}
