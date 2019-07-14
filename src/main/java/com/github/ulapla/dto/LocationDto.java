package com.github.ulapla.dto;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.Location;

public class LocationDto {

    private Long id;
    private String place;
    private String position;
    private int quantity;
    private String[] items;

    public LocationDto() {
    }

    public LocationDto(Location that) {
        this.id = that.getId();
        this.place = that.getPlace();
        this.position = that.getPosition();
        this.quantity = that.getQuantity();
        this.items = that.getItems().stream()
                .map(LocationDto::apply)
                .toArray(String[]::new);

    }

    private static String apply(Item item) {
        return item.getName() + " " + item.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
}
