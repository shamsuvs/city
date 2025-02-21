package com.smashplus.cityxplor.dto;

import java.util.List;

public class GenericResponse<T> {
    private List<T> items;
    private T item; // Field for a single item

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
