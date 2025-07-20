package com.example.Healthcare.service.implementation;

import com.example.Healthcare.model.Facility;
import com.example.Healthcare.repository.FacilityRepository;
import com.example.Healthcare.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facility not found with id: " + id));
    }

    @Override
    public Facility createFacility(Facility facility) {
        return facilityRepository.save(facility);
    }
    public Facility updateFacility(Long id, Facility updatedFacility) {
    Facility existing = facilityRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Facility not found"));
    
    existing.setName(updatedFacility.getName());
    existing.setType(updatedFacility.getType());
    existing.setAddress(updatedFacility.getAddress());
    //existing.setUpdatedAt(LocalDateTime.now());
    
    return facilityRepository.save(existing);
}

}
