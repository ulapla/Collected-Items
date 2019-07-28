package com.github.ulapla.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy = "userId")
    private Set<Item> items;
    @OneToMany(mappedBy = "userId")
    private Set<Category> categories;
    @OneToMany(mappedBy = "userId")
    private Set<Location> locations;
}