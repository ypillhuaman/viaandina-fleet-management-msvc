package com.viaandina.msvc.fleetmanagement.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteVehicleAssignmentDTO {
    private Integer id;
    private Integer routeId;
    private Integer scheduleId;
    private Integer vehicleId;
    private LocalDate assignmentDate;
}
