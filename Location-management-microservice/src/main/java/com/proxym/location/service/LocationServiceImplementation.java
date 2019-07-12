package com.proxym.location.service;

import com.proxym.location.entity.Location;
import com.proxym.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return this.locationRepository.save(location);
    }

    @Override
    public Location getLocationById(Integer id) {
        return this.locationRepository.getOne(id);
    }

    @Override
    public List<Location> getLocationForUser(Integer user_id) {
        List<Location> locations = (List<Location>) locationRepository
                .getLocationForUser(user_id);
        return locations;
    }


}
