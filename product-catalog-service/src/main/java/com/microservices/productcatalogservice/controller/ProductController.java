package com.microservices.productcatalogservice.controller;

import com.microservices.productcatalogservice.model.Product;
import com.microservices.productcatalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    private List<Product> getAllProducts(){
        System.out.println("query executing . . .");
        return productService.getAllProduct();
    }

    @GetMapping(value = "/products", params = "category")
    private List<Product> getAllProductByCategory(@RequestParam("category") String category){
        return productService.getAllProductByCategory(category);
    }

    @GetMapping(value = "/products/{id}")
    private Product getOneProductById(@PathVariable("id") long id){
        return productService.getOneById(id);
    }

    @GetMapping(value = "/products", params = "name")
    private List<Product> getAllProductsByName(@RequestParam("name") String name){
        return productService.getAllProductsByName(name);
    }
}
