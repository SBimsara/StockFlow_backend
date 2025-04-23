package com.sithirabimsara.stockflow.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequestDTO {

    private String name;
    private String description;
    private Float price;
    private Integer quantity;
    private Long supplierId;

}
