package com.proxym.user.repository;

/**
 * @author Anis OURAJINI
 */
import com.proxym.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
