package com.davidorellana.dbpostgresql.product.repository;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
