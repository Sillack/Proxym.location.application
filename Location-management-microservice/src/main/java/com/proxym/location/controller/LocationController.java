package com.proxym.location.controller;

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
import java.util.stream.Collectors;

/**
 * @author Anis OURAJINI
 */
@RestController
@Api(value = "Locations Management Service")
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationServiceImplementation locationServiceImplementation;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/all")
    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationServiceImplementation.getAllLocations();
        return locations.stream()
                .map(location -> convertToDto(location))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get locations by user")
    @RequestMapping(method = RequestMethod.GET, value = "/all/byuser")
    public List<LocationDto> getAllLocations(Integer id_user) {
        List<Location> locations = locationServiceImplementation
                .getLocationForUser(id_user);
        return locations.stream()
                .map(location -> convertToDto(location))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add location")
    @PostMapping("/addlocation")
    public LocationDto addNewLocation(@RequestBody LocationDto locationDto) throws ParseException {
        Location location = convertToEntity(locationDto);
        Location locationCreated = locationServiceImplementation.addLocation(location);
        return convertToDto(locationCreated);
    }

    @ApiOperation(value = "get location by id")
    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable("id") Integer id) {
        return convertToDto(locationServiceImplementation.getLocationById(id));
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
