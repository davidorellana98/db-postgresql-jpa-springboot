package com.davidorellana.dbpostgresql.product.repository;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;

import java.util.List;

public interface ProductRepositoryDao {

    List<Product> getAllProducts();
    Product findProductById(Long idProduct);
    Product createProduct(ProductDto productDto);
    Product updateProductById(Long idProduct, ProductDto productDto);
    Boolean deleteProductById(Long idProduct);
}
