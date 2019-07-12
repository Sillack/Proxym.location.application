package com.proxym.location.service;

import com.proxym.location.entity.Location;

import java.util.List;


public interface LocationService {

    List<Location> getAllLocations();

    Location addLocation(Location location);

    Location getLocationById(Integer id);

    List<Location> getLocationForUser(Integer user_id);

}
