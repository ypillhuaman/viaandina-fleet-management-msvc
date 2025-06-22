package com.viaandina.msvc.fleetmanagement.app.mappers;

import org.mapstruct.Mapper;

import com.viaandina.msvc.fleetmanagement.app.dtos.VehicleDTO;
import com.viaandina.msvc.fleetmanagement.app.entities.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleDTO toDto(Vehicle vehicle);
    Vehicle toEntity(VehicleDTO dto);
}