package com.viaandina.msvc.fleetmanagement.app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.viaandina.msvc.fleetmanagement.app.dtos.ScheduleDTO;

@FeignClient(name = "viaandina-scheduler-msvc", contextId = "scheduleClient")
public interface ScheduleFeignClient {

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id);

}
