package com.davidorellana.dbpostgresql.purchase.repository;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.service.ProductService;
import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepositoryDao {

    @Autowired
    @Lazy
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductService productService;

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
        for (Long productId : purchaseDto.getIdProducts()) {
            Product productFound = productService.findProductById(productId);
            newPurchase.addProducts(productFound);
        }
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
}
