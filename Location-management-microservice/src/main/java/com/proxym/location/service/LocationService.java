package com.proxym.location.service;

import com.proxym.location.dao.LocationRepository;
import com.proxym.location.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return this.locationRepository.findAll();
    }


    public Location addLocation(Location location) {

        return this.locationRepository.saveAndFlush(location);
    }

    public Location getLocationById(Integer id) {
        return this.locationRepository.getOne(id);
    }
}
