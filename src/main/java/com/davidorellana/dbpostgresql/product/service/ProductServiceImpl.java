package com.davidorellana.dbpostgresql.product.service;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;
import com.davidorellana.dbpostgresql.product.repository.ProductRepository;
import com.davidorellana.dbpostgresql.product.repository.ProductRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Lazy
    private ProductRepositoryDao productRepositoryDao;

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryDao.getAllProducts();
    }

    @Override
    public Product findProductById(Long idProduct) {
        return productRepositoryDao.findProductById(idProduct);
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        return productRepositoryDao.createProduct(productDto);
    }

    @Override
    public Product updateProductById(Long idProduct, ProductDto productDto) {
        return productRepositoryDao.updateProductById(idProduct, productDto);
    }

    @Override
    public Boolean deleteProductById(Long idProduct) {
        return productRepositoryDao.deleteProductById(idProduct);
    }
}
