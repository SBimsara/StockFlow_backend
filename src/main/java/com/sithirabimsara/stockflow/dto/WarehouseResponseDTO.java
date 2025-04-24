package com.sithirabimsara.stockflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WarehouseResponseDTO {

    private Long id;
    private String location;
    private String email;
    private Float capacity;
    private String contactNumber;
    private String contactPerson;
}
