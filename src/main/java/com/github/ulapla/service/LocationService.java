package com.github.ulapla.service;

import com.github.ulapla.dto.LocationDto;
import com.github.ulapla.model.Location;
import com.github.ulapla.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> findAll(){
        return locationRepository.findAll().stream()
                .map(LocationDto::new)
                .collect(Collectors.toList());
    }
}
