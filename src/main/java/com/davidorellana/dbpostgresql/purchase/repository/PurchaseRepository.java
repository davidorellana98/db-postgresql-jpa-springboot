package com.davidorellana.dbpostgresql.purchase.repository;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByIdUser(Long idUser);
    List<Purchase> findByIdProduct(Long idProduct);
}
