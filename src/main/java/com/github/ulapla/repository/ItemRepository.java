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

     Page<Item> findByNameContainingAndUserId(String name, Pageable pageable, Long userId);
     Page<Item> findByCategoryAndUserId(Category category, Pageable pageable, Long userId);
     Page<Item> findByDescriptionContainingAndUserId(String string, Pageable pageable, Long userId);

    @Query(value = "SELECT SUM(quantity) FROM item;", nativeQuery = true)
    int allItemsSum();

    Page<Item> findAllByUserId(Pageable pageable, Long userId);
    List<Item> findAllByUserId(Long userId);


}
