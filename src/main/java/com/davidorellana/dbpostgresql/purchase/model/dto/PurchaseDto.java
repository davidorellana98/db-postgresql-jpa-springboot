package com.davidorellana.dbpostgresql.purchase.model.dto;

import com.davidorellana.dbpostgresql.purchase.model.data.Payment;

import java.time.LocalDate;

public class PurchaseDto {

    private Long idUser;
    private Long idProduct;
    private Payment payment;
    private Double priceTotalPurchase;

    public PurchaseDto() { }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getPriceTotalPurchase() {
        return priceTotalPurchase;
    }

    public void setPriceTotalPurchase(Double priceTotalPurchase) {
        this.priceTotalPurchase = priceTotalPurchase;
    }
}
