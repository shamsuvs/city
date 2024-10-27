package com.smashplus.cityxplor.dto;

import java.util.List;


public class EstablishmentResponse {
    public List<EstablishmentDTO> items;

    public List<EstablishmentDTO> getItems() {
        return items;
    }

    public void setItems(List<EstablishmentDTO> items) {
        this.items = items;
    }
}
