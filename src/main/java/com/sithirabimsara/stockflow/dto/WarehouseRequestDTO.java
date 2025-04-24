package com.sithirabimsara.stockflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WarehouseRequestDTO {

    private String location;
    private String email;
    private Float capacity;
    private String contactNumber;
    private String contactPerson;
    

}