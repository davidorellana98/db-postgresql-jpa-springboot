package com.davidorellana.dbpostgresql.purchase.service;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;
import com.davidorellana.dbpostgresql.purchase.repository.PurchaseRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    @Lazy
    private PurchaseRepositoryDao purchaseRepositoryDao;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepositoryDao.getAllPurchases();
    }

    @Override
    public Purchase findPurchaseById(Long idPurchase) {
        return purchaseRepositoryDao.findPurchaseById(idPurchase);
    }

    @Override
    public Purchase createPurchase(PurchaseDto purchaseDto) {
        return purchaseRepositoryDao.createPurchase(purchaseDto);
    }

    @Override
    public Purchase updatePurchaseById(Long idPurchase, PurchaseDto purchaseDto) {
        return purchaseRepositoryDao.updatePurchaseById(idPurchase, purchaseDto);
    }

    @Override
    public Boolean deletePurchaseById(Long idPurchase) {
        return purchaseRepositoryDao.deletePurchaseById(idPurchase);
    }

    @Override
    public List<Purchase> findByIdUser(Long idUser) {
        return purchaseRepositoryDao.findByIdUser(idUser);
    }

    @Override
    public List<Purchase> findByIdProduct(Long idProduct) {
        return purchaseRepositoryDao.findByIdProduct(idProduct);
    }
}
