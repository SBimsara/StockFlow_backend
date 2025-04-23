package com.sithirabimsara.stockflow.repo;

import com.sithirabimsara.stockflow.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}
