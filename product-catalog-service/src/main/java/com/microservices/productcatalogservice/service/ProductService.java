package com.microservices.productcatalogservice.service;


import com.microservices.productcatalogservice.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public List<Product> getAllProductByCategory(String category);
    public Product getOneById(Long id);
    public List<Product> getAllProductsByName(String name);
    public Product addProduct(Product product);
    public void deleteProduct(Long productId);
}
