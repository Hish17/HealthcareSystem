package com.example.Healthcare.service;


import com.example.Healthcare.model.Facility;

import java.util.List;

public interface FacilityService {
    List<Facility> getAllFacilities();
    Facility getFacilityById(Long id);
    Facility createFacility(Facility facility);
}

