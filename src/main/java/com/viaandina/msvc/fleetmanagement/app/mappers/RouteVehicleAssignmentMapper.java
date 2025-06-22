package com.viaandina.msvc.fleetmanagement.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.viaandina.msvc.fleetmanagement.app.dtos.RouteVehicleAssignmentDTO;
import com.viaandina.msvc.fleetmanagement.app.entities.RouteVehicleAssignment;

@Mapper(componentModel = "spring")
public interface RouteVehicleAssignmentMapper {
    @Mapping(source = "vehicle.id", target = "vehicleId")
    RouteVehicleAssignmentDTO toDto(RouteVehicleAssignment entity);

    @Mapping(source = "vehicleId", target = "vehicle.id")
    RouteVehicleAssignment toEntity(RouteVehicleAssignmentDTO dto);
}

