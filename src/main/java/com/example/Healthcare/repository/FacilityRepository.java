package com.example.Healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.model.Patient;

public interface FacilityRepository extends JpaRepository<Patient, Long> { }
