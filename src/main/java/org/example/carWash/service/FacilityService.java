package org.example.carWash.service;

import org.example.carWash.model.Facility;
import org.example.carWash.repos.FacilityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    private final FacilityRepo facilityRepo;

    public FacilityService(FacilityRepo facilityRepo) {
        this.facilityRepo = facilityRepo;
    }

    public List<Facility> getAllServices() {
       return facilityRepo.findAll();
    }

    public Facility add(Facility facility) {
        Facility newFacility = new Facility();
        newFacility.setName(facility.getName());
        newFacility.setPrice(facility.getPrice());

        return facilityRepo.save(newFacility);
    }

    public void delete(Long id) {
        facilityRepo.deleteById(id);
    }
}
