package com.davidorellana.dbpostgresql.product.model.data;

import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;
import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long idProduct;
    private String nameProduct;
    private String brand;
    private String category;
    private String description;
    @Column(name = "quantity_products")
    @Min(value = 1, message = "The minimum quantity of products must be 1.")
    private Integer quantityProducts;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Specify your ranking (ONE_STAR, TWO_STAR, THREE_STAR, FOUR_STAR, FIVE_STAR).")
    private Ranking ranking;
    @Column(name = "image_product")
    private String imageProduct;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Purchase> purchase;

    public Product() { }

    public Product(ProductDto productDto) {
        this.nameProduct = productDto.getNameProduct();
        this.brand = productDto.getBrand();
        this.category = productDto.getCategory();
        this.description = productDto.getDescription();
        this.quantityProducts = productDto.getQuantityProducts();
        this.unitPrice = productDto.getUnitPrice();
        this.ranking = productDto.getRanking();
        this.imageProduct = productDto.getImageProduct();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(Integer quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category) && Objects.equals(description, product.description) && Objects.equals(quantityProducts, product.quantityProducts) && Objects.equals(unitPrice, product.unitPrice) && ranking == product.ranking && Objects.equals(imageProduct, product.imageProduct) && Objects.equals(purchase, product.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, brand, category, description, quantityProducts, unitPrice, ranking, imageProduct, purchase);
    }
}
