package com.viaandina.msvc.fleetmanagement.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "route_vehicle_assignments", schema = "fleet_management")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteVehicleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer routeId;
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private LocalDate assignmentDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String updatedBy;
}