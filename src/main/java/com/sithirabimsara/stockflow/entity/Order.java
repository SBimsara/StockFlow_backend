package com.sithirabimsara.stockflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "order_id")
    private Long id;

    @NotNull(message = "Order date is required")
    private LocalDate orderDate;

    private LocalDate deliveryDate;

    @NotNull(message = "Total amount is required")
    private Float totalAmount;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    // @ManyToOne
    // @JoinColumn(name = "customer_id")
    // private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
