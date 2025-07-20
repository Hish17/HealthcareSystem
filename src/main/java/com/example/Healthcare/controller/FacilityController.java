package com.example.Healthcare.controller;


import com.example.Healthcare.model.Facility;
import com.example.Healthcare.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable Long id) {
        return facilityService.getFacilityById(id);
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityService.createFacility(facility);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        return facilityService.updateFacility(id, facility);
    }

}

