package com.sithirabimsara.stockflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sithirabimsara.stockflow.dto.WarehouseRequestDTO;
import com.sithirabimsara.stockflow.dto.WarehouseResponseDTO;
import com.sithirabimsara.stockflow.service.WarehouseService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping(value = "api/v1/warehouse")
@CrossOrigin(origins = "*")

public class WarehouseController {


    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<WarehouseResponseDTO>> getAllWarehouses() {
        List<WarehouseResponseDTO> warehouseResponseDTOList = warehouseService.findAllWarehouses();
        return new ResponseEntity<>(warehouseResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WarehouseResponseDTO> getWarehouseById(@PathVariable("id") Long id) {
        WarehouseResponseDTO warehouseResponseDTO = warehouseService.getWarehouseById(id);
        return new ResponseEntity<>(warehouseResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<WarehouseResponseDTO> saveWarehouse(@Valid @RequestBody WarehouseRequestDTO warehouseRequestDTO){
        WarehouseResponseDTO savedWarehouse = warehouseService.saveWarehouse(warehouseRequestDTO);
        return new ResponseEntity<>(savedWarehouse, HttpStatus.CREATED);
    }


    
    
    
    
}