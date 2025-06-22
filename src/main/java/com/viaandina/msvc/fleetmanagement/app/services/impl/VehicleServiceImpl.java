package com.viaandina.msvc.fleetmanagement.app.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaandina.msvc.fleetmanagement.app.dtos.VehicleDTO;
import com.viaandina.msvc.fleetmanagement.app.entities.Vehicle;
import com.viaandina.msvc.fleetmanagement.app.mappers.VehicleMapper;
import com.viaandina.msvc.fleetmanagement.app.repositories.VehicleRepository;
import com.viaandina.msvc.fleetmanagement.app.services.VehicleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public List<VehicleDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleDTO findById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Not found")));
    }

    public VehicleDTO save(VehicleDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
    
    public VehicleDTO update(VehicleDTO dto) {
        Vehicle existing = repository.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Vehicle updated = mapper.toEntity(dto);
        updated.setId(existing.getId());

        return mapper.toDto(repository.save(updated));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
