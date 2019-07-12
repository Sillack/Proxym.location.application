package com.proxym.location.repository;

/**
 * @author Anis OURAJINI
 */

import com.proxym.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM locations l where l.id_user = ?1")
    List<Location> getLocationForUser(Integer user_id);
}