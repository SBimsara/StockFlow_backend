package com.sithirabimsara.stockflow.service;

import com.sithirabimsara.stockflow.dto.ProductRequestDTO;
import com.sithirabimsara.stockflow.dto.ProductResponseDTO;
import com.sithirabimsara.stockflow.entity.Product;
import com.sithirabimsara.stockflow.entity.Supplier;
import com.sithirabimsara.stockflow.repo.ProductRepo;
import com.sithirabimsara.stockflow.repo.SupplierRepo;
import org.antlr.v4.runtime.Token;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;
    


    public List<ProductResponseDTO> findAllProducts() {
        List<Product> productsList = productRepo.findAll();
        return modelMapper.map(productsList, new TypeToken<List<ProductResponseDTO>>(){}.getType());

    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {

        Supplier existingSupplier = supplierRepo.findById(productRequestDTO.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        Product newProduct = Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .supplier(existingSupplier)
                .build();
        Product savedProduct = productRepo.save(newProduct);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }
}
