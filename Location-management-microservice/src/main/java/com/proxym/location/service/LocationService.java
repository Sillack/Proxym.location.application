package com.proxym.location.service;

import com.proxym.location.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LocationService {

    List<Location> getAllLocations();

    Location addLocation(Location location);

    Optional<Location> getLocationById(Integer id);
}
