package com.sithirabimsara.stockflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sithirabimsara.stockflow.entity.Warehouse;

public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {

}
