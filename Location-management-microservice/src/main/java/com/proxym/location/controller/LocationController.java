package com.proxym.location.controller;

import com.proxym.location.dto.Dto;
import com.proxym.location.dto.LocationDto;
import com.proxym.location.entity.Location;
import com.proxym.location.service.LocationServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(value = "Locations Management Service")
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationServiceImplementation locationServiceImplementation;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/all")
    @Dto(LocationDto.class)
    public List<LocationDto> getAllUsers() {
        List<Location> locations = locationServiceImplementation.getAllLocations();
        return locations.stream()
                .map(location -> convertToDto(location))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add a location")
    @PostMapping("/addlocation")
    @Dto(LocationDto.class)
    public LocationDto addNewLocation(@RequestBody Location location) {
//        Image image=new Image();
//        image.setName("test");
//        image.setSize("test");
//        image.setConfiguration("test");
//        Location location1=new Location();
//        location1.setId_user("1");
//        location1.setDescription("test");
//        location1.setImage(image);
        return convertToDto(this.locationServiceImplementation.addLocation(location));
    }


    @GetMapping("/{id}")
//    @Dto(LocationDto.class)
    public Optional<Location> getLocationById(@PathVariable(value = "id") Integer id) {
        return this.locationServiceImplementation.getLocationById(id);
    }


    private LocationDto convertToDto(Location location) {
        LocationDto locationDto = modelMapper.map(location, LocationDto.class);
        return locationDto;
    }

    private Location convertToEntity(LocationDto locationDto) throws ParseException {
        Location location = modelMapper.map(locationDto, Location.class);
        return location;
    }
}
