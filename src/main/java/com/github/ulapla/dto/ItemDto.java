package com.github.ulapla.dto;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.Location;

public class ItemDto {

    private Long id;
    private String name;
    private String type;
    private String description;
    private int quantity;
    private String filePath;
    private String[] location;

    public ItemDto() {
    }

    public ItemDto(Item that) {
        this.id = that.getId();
        this.name = that.getName();
        this.type = that.getCategory().getName();
        this.description = that.getDescription();
        this.quantity = that.getQuantity();
        this.filePath = that.getFilePath();
        this.location = that.getItemLocations().stream()
                .map(itemLocation -> itemLocation.getLocation().getPlace() + " " + itemLocation.getLocation().getPosition())
                .toArray(String[]::new);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String[] getLocations() {
        return location;
    }

    public void setLocations(String[] locations) {
        this.location = locations;
    }
}
