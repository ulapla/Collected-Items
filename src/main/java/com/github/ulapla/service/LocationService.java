package com.github.ulapla.service;

import com.github.ulapla.model.Location;
import com.github.ulapla.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll(Long userId){
        return locationRepository.findAllByUserId(userId);
    }

    public Location findOneById(Long id){
        return locationRepository.findById(id).get();
    }

    public void saveLocation(Location location){
        locationRepository.save(location);
    }

    public void deleteById(Long id){
        locationRepository.deleteById(id);
    }
}
