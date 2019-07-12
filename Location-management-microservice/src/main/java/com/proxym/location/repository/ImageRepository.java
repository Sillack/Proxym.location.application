package com.proxym.location.repository;

/**
 * @author Anis OURAJINI
 */
import com.proxym.location.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
