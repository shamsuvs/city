package com.smashplus.cityxplor.slaitz.response;

import com.smashplus.cityxplor.slaitz.dto.SentenceDTO;

import java.util.List;

public class Response {
    public List<SentenceDTO> items;

    public List<SentenceDTO> getItems() {
        return items;
    }

    public void setItems(List<SentenceDTO> items) {
        this.items = items;
    }
}
