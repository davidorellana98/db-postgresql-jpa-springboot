package com.davidorellana.dbpostgresql.purchase.controller;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;
import com.davidorellana.dbpostgresql.purchase.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        List<Purchase> listAllPurchases = purchaseService.getAllPurchases();
        if (listAllPurchases.isEmpty()) {
            return new ResponseEntity("There are no purchases to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(listAllPurchases, HttpStatus.OK);
    }

    @GetMapping("/{idPurchase}")
    public ResponseEntity<Purchase> findPurchaseById(@PathVariable Long idPurchase){
        Purchase purchaseById = purchaseService.findPurchaseById(idPurchase);
        if (purchaseById != null) {
            return new ResponseEntity<>(purchaseById, HttpStatus.OK);
        }
        return new ResponseEntity("That purchase id does not exist!", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody @Valid PurchaseDto purchaseDto){
        Purchase purchaseValidation = purchaseService.createPurchase(purchaseDto);
        if (purchaseValidation != null) {
            return new ResponseEntity("Created purchase!", HttpStatus.CREATED);
        }
        return new ResponseEntity("Purchase not created!", HttpStatus.CONFLICT);    }

    @PutMapping("/{idPurchase}")
    public ResponseEntity<Purchase> updatePurchaseById(@PathVariable Long idPurchase, @RequestBody @Valid PurchaseDto purchaseDto){
        Purchase purchaseUpdated = purchaseService.updatePurchaseById(idPurchase, purchaseDto);
        if (purchaseUpdated != null){
            return new ResponseEntity("Updated purchase!", HttpStatus.OK);
        }

        return new ResponseEntity("Purchase not updated by id not found!", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{idPurchase}")
    public ResponseEntity deletePurchaseById(@PathVariable Long idPurchase){
        Boolean isDeletedPurchaseById = purchaseService.deletePurchaseById(idPurchase);
        if (isDeletedPurchaseById) {
            return new ResponseEntity("Deleted purchase!", HttpStatus.OK);
        }
        return new ResponseEntity("The purchase does not exist to be deleted!", HttpStatus.NOT_FOUND);

    }
}
