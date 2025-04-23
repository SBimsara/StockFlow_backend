package com.sithirabimsara.stockflow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String contactPerson;
    private String contactNumber;
}
