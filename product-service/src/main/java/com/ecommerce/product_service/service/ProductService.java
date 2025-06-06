package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;

import java.util.List;
public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product updateProduct);
    void deleteProduct(Long id);
}
