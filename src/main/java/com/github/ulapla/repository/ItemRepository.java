package com.github.ulapla.repository;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public Page<Item> findByNameContaining(String name, Pageable pageable);
    public Page<Item> findByCategory(Category category, Pageable pageable);
    public Page<Item> findByDescriptionContaining(String string, Pageable pageable);

    @Query(value = "SELECT SUM(quantity) FROM item", nativeQuery = true)
    int allItemsSum();


}
