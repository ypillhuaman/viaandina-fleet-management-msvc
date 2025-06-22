package com.viaandina.msvc.fleetmanagement.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.viaandina.msvc.fleetmanagement.app.clients.RouteFeignClient;
import com.viaandina.msvc.fleetmanagement.app.clients.ScheduleFeignClient;
import com.viaandina.msvc.fleetmanagement.app.dtos.RouteDTO;
import com.viaandina.msvc.fleetmanagement.app.dtos.RouteVehicleAssignmentDTO;
import com.viaandina.msvc.fleetmanagement.app.dtos.ScheduleDTO;
import com.viaandina.msvc.fleetmanagement.app.entities.RouteVehicleAssignment;
import com.viaandina.msvc.fleetmanagement.app.entities.Vehicle;
import com.viaandina.msvc.fleetmanagement.app.mappers.RouteVehicleAssignmentMapper;
import com.viaandina.msvc.fleetmanagement.app.repositories.RouteVehicleAssignmentRepository;
import com.viaandina.msvc.fleetmanagement.app.services.RouteVehicleAssignmentService;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RouteVehicleAssignmentServiceImpl implements RouteVehicleAssignmentService {

    @Autowired
    private RouteFeignClient routeClient;

    @Autowired
    private ScheduleFeignClient scheduleClient;

    private final RouteVehicleAssignmentRepository repository;
    private final RouteVehicleAssignmentMapper mapper;

    public List<RouteVehicleAssignmentDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public RouteVehicleAssignmentDTO findById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Not found")));
    }

    public RouteVehicleAssignmentDTO save(RouteVehicleAssignmentDTO dto) {
        RouteDTO routeDto = null;
        ScheduleDTO scheduleDTO = null;
        try {            
            ResponseEntity<RouteDTO> response = routeClient.findById(dto.getRouteId().longValue());
            routeDto = response.getBody();
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada con ID: " + dto.getRouteId());
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error al comunicarse con el servicio de rutas");
        }

        if (!routeDto.getActive()) {
            throw new RuntimeException("La ruta está inactiva");
        }

        try {            
            ResponseEntity<ScheduleDTO> response = scheduleClient.findById(dto.getScheduleId().longValue());
            scheduleDTO = response.getBody();
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario no encontrado con ID: " + dto.getScheduleId());
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error al comunicarse con el servicio de horarios");
        }

        if (!scheduleDTO.getActive()) {
            throw new RuntimeException("El horario está inactivo");
        }

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public RouteVehicleAssignmentDTO update(RouteVehicleAssignmentDTO dto) {
        RouteVehicleAssignment existing = repository.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Assignment not found"));

        RouteVehicleAssignment updated = mapper.toEntity(dto);
        updated.setId(existing.getId());

        return mapper.toDto(repository.save(updated));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
