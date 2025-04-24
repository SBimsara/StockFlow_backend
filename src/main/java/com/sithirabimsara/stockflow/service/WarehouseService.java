package com.sithirabimsara.stockflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sithirabimsara.stockflow.dto.WarehouseRequestDTO;
import com.sithirabimsara.stockflow.dto.WarehouseResponseDTO;
import com.sithirabimsara.stockflow.entity.Warehouse;
import com.sithirabimsara.stockflow.repo.WarehouseRepo;

public class WarehouseService {


    @Autowired
    private WarehouseRepo warehouseRepo;


    public List<WarehouseResponseDTO> findAllWarehouses(){
        List<Warehouse> warehousesList = warehouseRepo.findAll();
        return warehousesList.stream().map(this::mapWarehouseToWarehouseResponseDTO).toList();
    }

    public WarehouseResponseDTO getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepo.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return mapWarehouseToWarehouseResponseDTO(warehouse);
    }
    public WarehouseResponseDTO saveWarehouse(WarehouseRequestDTO warehouseRequestDTO) {
        Warehouse newWarehouse = mapWarehouseRequestDTOToWarehouse(warehouseRequestDTO);
        Warehouse savedWarehouse = warehouseRepo.save(newWarehouse);
        return mapWarehouseToWarehouseResponseDTO(savedWarehouse);
    }

    public void deleteWarehouse(Long id) {
        Warehouse warehouse = warehouseRepo.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouseRepo.delete(warehouse);
    }

    public WarehouseResponseDTO updateWarehouse(Long id, WarehouseRequestDTO warehouseRequestDTO) {
        Warehouse existingWarehouse = warehouseRepo.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        Warehouse.builder()
            .location(warehouseRequestDTO.getLocation())
            .email(warehouseRequestDTO.getEmail())
            .capacity(warehouseRequestDTO.getCapacity())
            .contactNumber(warehouseRequestDTO.getContactNumber())
            .contactPerson(warehouseRequestDTO.getContactPerson())
            .build();
        return mapWarehouseToWarehouseResponseDTO(warehouseRepo.save(existingWarehouse));
    }


    private WarehouseResponseDTO mapWarehouseToWarehouseResponseDTO(Warehouse warehouse) {
        return WarehouseResponseDTO.builder()
                .id(warehouse.getId())
                .location(warehouse.getLocation())
                .email(warehouse.getEmail())
                .capacity(warehouse.getCapacity())
                .contactNumber(warehouse.getContactNumber())
                .contactPerson(warehouse.getContactPerson())
                .build();
    }

    private Warehouse mapWarehouseRequestDTOToWarehouse(WarehouseRequestDTO warehouseRequestDTO) {
        return Warehouse.builder()
                .location(warehouseRequestDTO.getLocation())
                .email(warehouseRequestDTO.getEmail())
                .capacity(warehouseRequestDTO.getCapacity())
                .contactNumber(warehouseRequestDTO.getContactNumber())
                .contactPerson(warehouseRequestDTO.getContactPerson())
                .build();
    }



    
}
