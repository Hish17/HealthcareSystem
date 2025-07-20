package com.example.Healthcare.controller;

import com.example.Healthcare.model.Patient;
import com.example.Healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<Page<Patient>> getAllPatients(
            @RequestParam(required = false) String search,
            Pageable pageable) {

        Page<Patient> patients = (search != null && !search.isEmpty())
                ? patientService.searchPatientsByName(search, pageable)
                : patientService.getAllPatients(pageable);

        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.softDeletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<List<Patient>> getPatientsByFacility(@PathVariable Long facilityId) {
        return ResponseEntity.ok(patientService.getPatientsByFacilityId(facilityId));
    }
}
