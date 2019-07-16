package com.github.ulapla.repository;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByName(String name);
    public List<Item> findByCategory(Category category);
    public List<Item> findByDescriptionContaining(String string);

}
