package com.davidorellana.dbpostgresql.purchase.repository;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;
import com.davidorellana.dbpostgresql.user.model.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepositoryDao {

    @Autowired
    @Lazy
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase findPurchaseById(Long idPurchase) {
        Optional<Purchase> findPurchase = purchaseRepository.findById(idPurchase);
        if (findPurchase.isPresent()) {
            return findPurchase.get();
        }
        return null;
    }

    @Override
    public Purchase createPurchase(PurchaseDto purchaseDto) {
        Purchase newPurchase = new Purchase(purchaseDto);
        return purchaseRepository.save(newPurchase);
    }

    @Override
    public Purchase updatePurchaseById(Long idPurchase, PurchaseDto purchaseDto) {
        Purchase purchaseFound = findPurchaseById(idPurchase);
        if (purchaseFound != null) {
            purchaseFound.setPayment(purchaseDto.getPayment());
            purchaseFound.setPriceTotalPurchase(purchaseDto.getPriceTotalPurchase());
            return purchaseRepository.save(purchaseFound);
        }
        return null;
    }

    @Override
    public Boolean deletePurchaseById(Long idPurchase) {
        if (purchaseRepository.existsById(idPurchase)) {
            purchaseRepository.deleteById(idPurchase);
            return true;
        }
        return false;
    }

    @Override
    public List<Purchase> findByIdUser(Long idUser) {
        if (getAllPurchases().listIterator().next().getIdUser() != idUser) {
            return purchaseRepository.findByIdUser(idUser);
        }
        return getAllPurchases();
    }

    @Override
    public List<Purchase> findByIdProduct(Long idProduct) {
        if (getAllPurchases().listIterator().next().getIdProduct() != idProduct) {
            return purchaseRepository.findByIdProduct(idProduct);
        }
        return getAllPurchases();
    }
}
