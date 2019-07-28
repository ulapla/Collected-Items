package com.github.ulapla.repository;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.ItemLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemLocationRepository extends JpaRepository<ItemLocation, Long> {

    //@Query(value = "SELECT sum(quantity) FROM item_location where item_id = ?1 ", nativeQuery = true)
    @Query(value = "SELECT sum(i.quantity) FROM ItemLocation i where i.item = ?1 ")
    int sumItemQuantityFromLocations(Item item);

}
