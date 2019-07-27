package com.github.ulapla.controllers;

import com.github.ulapla.model.Location;
import com.github.ulapla.security.CurrentUser;
import com.github.ulapla.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public String allLocations(Model model, @AuthenticationPrincipal CurrentUser customUser){
        model.addAttribute("locations",locationService.findAll(customUser.getUser().getId()));
        return "location/all_location";
    }

    @GetMapping("/add")
    public String addLocation(Model model){
        model.addAttribute("location",new Location());
        return "/location/add_location";
    }

    @PostMapping("/add")
    public String saveLocation(@Valid Location location,
                               BindingResult result,
                               @AuthenticationPrincipal CurrentUser customUser){
        if (result.hasErrors()) {
            return "/location/add_location";
        }
        location.setUserId(customUser.getUser().getId());
        locationService.saveLocation(location);
        return "redirect:/api/location/add";
    }

    @GetMapping("/edit/{id}")
    public String editLocation(Model model, @PathVariable Long id){
        model.addAttribute("location", locationService.findOneById(id));
        return "location/edit_location";
    }

    @PostMapping("/edit/{id}")
    public String updateLocation(@Valid Location location, BindingResult result){
        if (result.hasErrors()) {
            return "/location/edit_location";
        }
        locationService.saveLocation(location);
        return "redirect:/api/location/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
        return "redirect:/api/location/all";
    }
}
