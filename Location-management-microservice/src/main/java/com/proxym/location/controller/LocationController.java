package com.proxym.location.controller;

import com.proxym.location.dto.Dto;
import com.proxym.location.dto.LocationDto;
import com.proxym.location.entity.Location;
import com.proxym.location.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/all")
    @Dto(LocationDto.class)
    public List<LocationDto> getAllUsers() {
        List<Location> locations = locationService.getAllLocations();
        return locations.stream()
                .map(location -> convertToDto(location))
                .collect(Collectors.toList());
    }

    @PostMapping("/addlocation")
    @Dto(LocationDto.class)
    public LocationDto addNewLocation(@RequestBody Location location) {
        return convertToDto(this.locationService.addLocation(location));
    }

    private LocationDto convertToDto(Location location) {
        LocationDto locationDto = modelMapper.map(location, LocationDto.class);
        return locationDto;
    }
}
