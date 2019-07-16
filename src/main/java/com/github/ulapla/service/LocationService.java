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

    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    public LocationDto findOneById(Long id){
        return new LocationDto(locationRepository.findById(id).get());
    }
}