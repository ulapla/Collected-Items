package com.github.ulapla.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    @Size(min=1)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private String fileName;
    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private Set<ItemLocation> itemLocations = new HashSet<>();
    @Min(0)
    private int quantity;
    private Long userId;


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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
