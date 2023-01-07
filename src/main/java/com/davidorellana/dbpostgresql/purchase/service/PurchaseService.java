package com.davidorellana.dbpostgresql.purchase.service;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {

    List<Purchase> getAllPurchases();
    Purchase findPurchaseById(Long idPurchase);
    Purchase createPurchase(PurchaseDto purchaseDto);
    Purchase updatePurchaseById(Long idPurchase, PurchaseDto purchaseDto);
    Boolean deletePurchaseById(Long idPurchase);
}
