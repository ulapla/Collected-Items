package com.github.ulapla.repository;

import com.github.ulapla.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

 List<Location> findAllByUserId(Long userId);
}
