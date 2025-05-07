package com.sithirabimsara.stockflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sithirabimsara.stockflow.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
