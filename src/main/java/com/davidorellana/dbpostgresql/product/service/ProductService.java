package com.davidorellana.dbpostgresql.product.service;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product findProductById(Long idProduct);
    Product createProduct(ProductDto productDto);
    Product updateProductById(Long idProduct, ProductDto productDto);
    Boolean deleteProductById(Long idProduct);
}
