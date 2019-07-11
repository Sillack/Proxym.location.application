package com.proxym.location.service;

import com.proxym.location.dao.LocationRepository;
import com.proxym.location.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImplementation implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location addLocation(Location location) {
        try {
            return this.locationRepository.save(location);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Location> getLocationById(Integer id) {
        return this.locationRepository.findById(id);
    }

}
