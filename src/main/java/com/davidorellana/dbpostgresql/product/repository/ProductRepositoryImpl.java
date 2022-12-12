package com.davidorellana.dbpostgresql.product.repository;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;
import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.naming.ldap.SortKey;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryDao {

    @Autowired
    @Lazy
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long idProduct) {
        Optional<Product> findProduct = productRepository.findById(idProduct);
        if (findProduct.isPresent()) {
            return findProduct.get();
        }
        return null;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product newProduct = new Product(productDto);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProductById(Long idProduct, ProductDto productDto) {
        Product productFound = findProductById(idProduct);
        if (productFound != null) {
            productFound.setNameProduct(productDto.getNameProduct());
            productFound.setBrand(productDto.getBrand());
            productFound.setCategory(productDto.getCategory());
            productFound.setDescription(productDto.getDescription());
            productFound.setQuantityProducts(productDto.getQuantityProducts());
            productFound.setUnitPrice(productDto.getUnitPrice());
            productFound.setRanking(productDto.getRanking());
            productFound.setImageProduct(productDto.getImageProduct());
            return productRepository.save(productFound);
        }
        return null;
    }

    @Override
    public Boolean deleteProductById(Long idProduct) {
        if (productRepository.existsById(idProduct)) {
            productRepository.deleteById(idProduct);
            return true;
        }
        return false;
    }
}
