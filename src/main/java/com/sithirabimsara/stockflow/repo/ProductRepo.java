package com.sithirabimsara.stockflow.repo;

import com.sithirabimsara.stockflow.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {


}
