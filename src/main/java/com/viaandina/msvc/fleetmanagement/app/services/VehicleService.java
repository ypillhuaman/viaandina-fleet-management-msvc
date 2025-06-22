package com.viaandina.msvc.fleetmanagement.app.services;

import java.util.List;

import com.viaandina.msvc.fleetmanagement.app.dtos.VehicleDTO;

public interface VehicleService {
    List<VehicleDTO> findAll();
    VehicleDTO findById(Integer id);
    VehicleDTO save(VehicleDTO dto);
    VehicleDTO update(VehicleDTO dto);
    void delete(Integer id);
}
