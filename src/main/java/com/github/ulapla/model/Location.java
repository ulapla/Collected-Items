package com.github.ulapla.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    @Size(min=1)
    private String place;
    private String position;
    @OneToMany(mappedBy = "location",cascade = CascadeType.REMOVE)
    private Set<ItemLocation> itemLocations;

    public String getName(){
        return this.place + " " +this.position;
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


    public Set<ItemLocation> getItemLocations() {
        return itemLocations;
    }

    public void setItemLocations(Set<ItemLocation> itemLocations) {
        this.itemLocations = itemLocations;
    }
}
