package com.sithirabimsara.stockflow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierRequestDTO {

    private String name;
    private String email;
    private String contactPerson;
    private String contactNumber;
}
