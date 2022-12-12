package com.davidorellana.dbpostgresql.product.controller;

import com.davidorellana.dbpostgresql.product.model.data.Product;
import com.davidorellana.dbpostgresql.product.model.dto.ProductDto;
import com.davidorellana.dbpostgresql.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> listAllProducts = productService.getAllProducts();
        if (listAllProducts.isEmpty()) {
            return new ResponseEntity("There are no products to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(listAllProducts, HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> findProductById(@PathVariable Long idProduct) {
        Product productById = productService.findProductById(idProduct);
        if (productById != null) {
            return new ResponseEntity<>(productById, HttpStatus.OK);
        }
        return new ResponseEntity("That product id does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Optional<Product> productValidation = Optional.ofNullable(productService.createProduct(productDto));
        if (productValidation != null) {
            return new ResponseEntity("Created product!", HttpStatus.CREATED);
        }
        return new ResponseEntity("Product not created!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long idProduct, @RequestBody ProductDto productDto) {
        Product productUpdated = productService.updateProductById(idProduct, productDto);
        if (productUpdated != null){
            return new ResponseEntity("Updated product!", HttpStatus.OK);
        }

        return new ResponseEntity("Product not updated by id not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity deleteUserById(@PathVariable Long idProduct) {
        Boolean isDeletedUserById = productService.deleteProductById(idProduct);
        if (isDeletedUserById) {
            return new ResponseEntity("Deleted product!", HttpStatus.OK);
        }
        return new ResponseEntity("The product does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}
