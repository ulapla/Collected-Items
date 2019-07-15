package com.github.ulapla.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private int quantity;
    private String filePath;
    @OneToMany(mappedBy = "item")
    private Set<ItemLocation> itemLocations;


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

    public Set<ItemLocation> getItemLocations() {
        return itemLocations;
    }

    public void setItemLocations(Set<ItemLocation> itemLocations) {
        this.itemLocations = itemLocations;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
