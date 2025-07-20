package com.example.Healthcare.repository;

import com.example.Healthcare.model.Facility;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // custom query methods
    Facility findByType(String type);
    List<Facility> findByDeletedFalse();
 }
