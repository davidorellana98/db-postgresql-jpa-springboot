package com.davidorellana.dbpostgresql.purchase.model.data;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.purchase.model.dto.PurchaseDto;
import com.davidorellana.dbpostgresql.user.model.data.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchases")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPurchase")
public class Purchase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase", nullable = false)
    private Long idPurchase;
    @Column(name = "id_user", nullable = false)
    private Long idUser;
    @Column(name = "id_product", nullable = false)
    private Long idProduct;
    @Column(name = "date_purchase")
    private LocalDate datePurchase;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Specify your payment method (CASH, CARD, PAYPAL, ALIPAY, BITCOIN).")
    private Payment payment;
    @Column(name = "price_total_purchase")
    @Min(value = 0, message = "The minimum total price of a purchase must be 0.")
    private Double priceTotalPurchase;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @JoinTable(
            name = "purchases_product",
            joinColumns = @JoinColumn(name = "fk_purchase", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_product", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> product;

    public Purchase() { }

    public Purchase(PurchaseDto purchaseDto) {
        this.idUser = purchaseDto.getIdUser();
        this.idProduct = purchaseDto.getIdProduct();
        this.datePurchase = LocalDate.now();
        this.payment = purchaseDto.getPayment();
        this.priceTotalPurchase = purchaseDto.getPriceTotalPurchase();
    }

    public Long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

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

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void addProducts(Product product){
        if (this.product == null){
            this.product = new ArrayList<>();
        }
        this.product.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(idPurchase, purchase.idPurchase) && Objects.equals(idUser, purchase.idUser) && Objects.equals(idProduct, purchase.idProduct) && Objects.equals(datePurchase, purchase.datePurchase) && payment == purchase.payment && Objects.equals(priceTotalPurchase, purchase.priceTotalPurchase) && Objects.equals(user, purchase.user) && Objects.equals(product, purchase.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPurchase, idUser, idProduct, datePurchase, payment, priceTotalPurchase, user, product);
    }
}
