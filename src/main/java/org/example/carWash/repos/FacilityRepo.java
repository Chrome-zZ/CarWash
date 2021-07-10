package org.example.carWash.repos;

import org.example.carWash.model.Facility;
import org.example.carWash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacilityRepo extends JpaRepository<Facility, Long> {
    Optional<Facility> findByName(String name);
}