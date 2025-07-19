package com.example.Healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> { }