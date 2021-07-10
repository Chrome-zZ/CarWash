package org.example.carWash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.carWash.model.Facility;
import org.example.carWash.service.FacilityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities")
@Api
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    @ApiOperation("Получить список всех услуг из БД")
    public List<Facility> getAllServices() {
        return facilityService.getAllServices();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    @ApiOperation("Добавить услугу в БД(для админа)")
    public Facility add(@RequestBody Facility facility) {
        return facilityService.add(facility);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    @ApiOperation("Удалить услугу из БД(для админа)")
    public void delete(@PathVariable Long id) {
        facilityService.delete(id);
    }
}