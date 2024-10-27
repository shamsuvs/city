package com.smashplus.cityxplor.slaitz.response;

import com.smashplus.cityxplor.slaitz.dto.PhonicsDTO;

import java.util.List;

public class PhonicsResponse {
    public List<PhonicsDTO> items;

    public List<PhonicsDTO> getItems() {
        return items;
    }

    public void setItems(List<PhonicsDTO> items) {
        this.items = items;
    }
}
