package com.viaandina.msvc.fleetmanagement.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaandina.msvc.fleetmanagement.app.dtos.VehicleDTO;
import com.viaandina.msvc.fleetmanagement.app.services.VehicleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @GetMapping
    public List<VehicleDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehicleDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public VehicleDTO create(@RequestBody VehicleDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public VehicleDTO update(@PathVariable Integer id, @RequestBody VehicleDTO dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

