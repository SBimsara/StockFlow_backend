package com.sithirabimsara.stockflow.controller;


import com.sithirabimsara.stockflow.dto.SupplierRequestDTO;
import com.sithirabimsara.stockflow.dto.SupplierResponseDTO;
import com.sithirabimsara.stockflow.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity<SupplierResponseDTO> saveSupplier(@Valid @RequestBody SupplierRequestDTO supplierRequestDTO) {
        SupplierResponseDTO supplierResponseDTO = supplierService.saveSupplier(supplierRequestDTO);
        return new ResponseEntity<>(supplierResponseDTO, HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplierById(@PathVariable("id") Long id){
        SupplierResponseDTO supplierResponseDTO = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupplierResponseDTO>> getAllSuppliers(){
        List<SupplierResponseDTO> suppliers = supplierService.findAllSuppliers();
        return new ResponseEntity<>(suppliers,HttpStatus.OK);
    }
}
