package com.sithirabimsara.stockflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "customer_id")
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Contact number is required")
    private String contactNumber;

    // @OneToMany(mappedBy = "customer")
    // private List<Order> orders;

}
