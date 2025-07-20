package com.example.Healthcare.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> { 
    List<Patient> findByFacilityId(Long facilityId);
    // List<Patient> findByFacilityIdAndDeletedFalse(Long facilityId);
    Page<Patient> findByNameContainingIgnoreCase(String name, Pageable pageable);
}