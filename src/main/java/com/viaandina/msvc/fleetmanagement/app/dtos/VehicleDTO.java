package com.viaandina.msvc.fleetmanagement.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {
    private Integer id;
    private String licensePlate;
    private String model;
    private Integer capacity;
    private Boolean active;
}
