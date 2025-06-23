package com.viaandina.msvc.fleetmanagement.app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.viaandina.msvc.fleetmanagement.app.dtos.RouteDTO;

@FeignClient(name = "viaandina-scheduler-msvc", contextId = "routeClient")
public interface RouteFeignClient {

    @GetMapping("/routes/{id}")
    ResponseEntity<RouteDTO> findById(@PathVariable Long id);
}
