package com.sithirabimsara.stockflow.dto;

import java.time.LocalDate;
import java.util.List;

import com.sithirabimsara.stockflow.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponseDTO {

    private Long id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Float totalAmount;
    private List<Product> products;
}
