package com.example.Healthcare.service;

import com.example.Healthcare.model.Patient;
import com.example.Healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients (paginated)
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    // Get a single patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update existing patient
    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedPatient.getName());
                    existing.setAge(updatedPatient.getAge());
                    existing.setGender(updatedPatient.getGender());
                    existing.setFacility(updatedPatient.getFacility());
                    return patientRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    // Soft delete a patient
    public void softDeletePatient(Long id) {
        patientRepository.findById(id).ifPresent(patient -> {
            patient.setDeleted(true);
            patientRepository.save(patient);
        });
    }

    // Get all patients for a specific facility
    public List<Patient> getPatientsByFacilityId(Long facilityId) {
        return patientRepository.findByFacilityId(facilityId);
    }

    // Search patients by name
    public Page<Patient> searchPatientsByName(String name, Pageable pageable) {
        return patientRepository.findByNameContainingIgnoreCase(name, pageable);
    }
}
