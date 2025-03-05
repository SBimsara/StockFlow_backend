package com.sithirabimsara.stockflow.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "supplier_id")
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Email is invalid")
    private String email;

    @NotEmpty(message = "Contact person is required")
    private String contactPerson;

    @NotBlank(message = "Contact number is required")
    private String contactNumber;

    @OneToMany(mappedBy = "supplier")
    private List<Product> product;
}
