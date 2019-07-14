package com.github.ulapla.controllers;

import com.github.ulapla.dto.LocationDto;
import com.github.ulapla.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("get/all")
    @ResponseBody
    public List<LocationDto> getLocations(){
        return locationService.findAll();
    }
}
