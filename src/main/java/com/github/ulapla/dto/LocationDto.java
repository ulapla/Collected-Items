package com.github.ulapla.dto;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.Location;

public class LocationDto {

    private Long id;
    private String place;
    private String position;
    private String[] items;


    public LocationDto() {
    }

    public LocationDto(Location that) {
        this.id = that.getId();
        this.place = that.getPlace();
        this.position = that.getPosition();
        this.items = that.getItemLocations().stream()
                .map(itemLocation -> itemLocation.getItem().getType() + " " + itemLocation.getItem().getName())
                .toArray(String[]::new);

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

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
}
