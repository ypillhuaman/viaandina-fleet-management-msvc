package com.viaandina.msvc.fleetmanagement.app.services;

import java.util.List;

import com.viaandina.msvc.fleetmanagement.app.dtos.RouteVehicleAssignmentDTO;

public interface RouteVehicleAssignmentService {
    List<RouteVehicleAssignmentDTO> findAll();
    RouteVehicleAssignmentDTO findById(Integer id);
    RouteVehicleAssignmentDTO save(RouteVehicleAssignmentDTO dto);
    RouteVehicleAssignmentDTO update(RouteVehicleAssignmentDTO dto);
    void delete(Integer id);
}
