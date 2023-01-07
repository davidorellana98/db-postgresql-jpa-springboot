package com.davidorellana.dbpostgresql.purchase.model.dto;

import com.davidorellana.dbpostgresql.purchase.model.data.Payment;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PurchaseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long idUser;
    private Long idProduct;
    private Payment payment;
    private Double priceTotalPurchase;
    private List<Long> idProducts;

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

    public List<Long> getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(List<Long> idProducts) {
        this.idProducts = idProducts;
    }
}
