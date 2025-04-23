package com.sithirabimsara.stockflow.service;

import com.sithirabimsara.stockflow.dto.SupplierRequestDTO;
import com.sithirabimsara.stockflow.dto.SupplierResponseDTO;
import com.sithirabimsara.stockflow.entity.Supplier;
import com.sithirabimsara.stockflow.repo.SupplierRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Save a new Supplier
    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDTO) {

        Supplier newSupplier = modelMapper.map(supplierRequestDTO, Supplier.class);
        Supplier savedSupplier = supplierRepo.save(newSupplier);
        return modelMapper.map(savedSupplier, SupplierResponseDTO.class);

    }

    // Get a Supplier by ID
    public SupplierResponseDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        return modelMapper.map(supplier, SupplierResponseDTO.class);
    }

    // Get all Suppliers
    public List<SupplierResponseDTO> findAllSuppliers() {
        List<Supplier> supplierList = supplierRepo.findAll();
        return modelMapper.map(supplierList,new TypeToken<List<SupplierResponseDTO>>(){}.getType());
    }



}
