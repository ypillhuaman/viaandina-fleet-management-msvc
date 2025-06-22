package com.viaandina.msvc.fleetmanagement.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viaandina.msvc.fleetmanagement.app.entities.RouteVehicleAssignment;

@Repository
public interface RouteVehicleAssignmentRepository extends JpaRepository<RouteVehicleAssignment, Integer> {
}
