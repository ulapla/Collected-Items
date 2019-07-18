package com.github.ulapla.model;

import org.hibernate.annotations.OnDelete;

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
    private String filePath;
    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private Set<ItemLocation> itemLocations = new HashSet<>();
    @Min(0)
    private int quantity;


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

    public void setQuantity() { // TODO: 17.07.19  move to service
        if (itemLocations.size() > 0) {
            quantity = itemLocations.stream()
                    .map(ItemLocation::getQuantity)
                    .reduce(Integer::sum)
                    .get();
        } else {
            quantity = 0;
        }
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
