package com.sithirabimsara.stockflow.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;
    private SupplierResponseDTO supplier;
}
