package com.sithirabimsara.stockflow.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "warehouse_id")
    private Long id;

    @NotEmpty(message = "Location is required")
    private String location;

    @Email(message = "Email is invalid")
    private String email;

    @NotNull(message = "Capacity is required")
    private Float capacity;

    @NotEmpty(message = "Contact number is required")
    private String contactNumber;

    @NotEmpty(message = "Contact person is required")
    private String contactPerson;

    @ManyToMany
    @JoinTable(
            name = "warehouse_product",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @OneToMany(mappedBy = "warehouse")
    private List<Shipment> shipment;
}
