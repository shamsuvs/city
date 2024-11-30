package com.smashplus.cityxplor.dto;

import java.util.List;


public class NewsResponse {
    public List<NewsDTO> items;

    public List<NewsDTO> getItems() {
        return items;
    }

    public void setItems(List<NewsDTO> items) {
        this.items = items;
    }
}
