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

import com.viaandina.msvc.fleetmanagement.app.dtos.RouteVehicleAssignmentDTO;
import com.viaandina.msvc.fleetmanagement.app.services.RouteVehicleAssignmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class RouteVehicleAssignmentController {

    private final RouteVehicleAssignmentService service;

    @GetMapping
    public List<RouteVehicleAssignmentDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RouteVehicleAssignmentDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public RouteVehicleAssignmentDTO create(@RequestBody RouteVehicleAssignmentDTO dto) {
        return service.save(dto);
    }
    
    @PutMapping("/{id}")
    public RouteVehicleAssignmentDTO update(@PathVariable Integer id, @RequestBody RouteVehicleAssignmentDTO dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
