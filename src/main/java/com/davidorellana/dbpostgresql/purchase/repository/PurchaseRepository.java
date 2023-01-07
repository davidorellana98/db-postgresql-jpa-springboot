package com.davidorellana.dbpostgresql.purchase.repository;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> { }
