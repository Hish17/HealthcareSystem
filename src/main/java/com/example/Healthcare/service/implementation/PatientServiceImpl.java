package com.example.Healthcare.service.implementation;

import com.example.Healthcare.model.Patient;
import com.example.Healthcare.repository.PatientRepository;
import com.example.Healthcare.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedPatient.getName());
                    existing.setAge(updatedPatient.getAge());
                    existing.setFacility(updatedPatient.getFacility());
                    return patientRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
