package com.product.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.application.model.Product_model;
import com.product.application.services.Product_service;

@RestController
@RequestMapping("/api/products")


public class Product_controller {

	   
	    @GetMapping("/hello")
	    public String sayHello() {
	        return "Hello, welcome to the e-commerce system!";
	    }
	   
	    @Autowired
	    private Product_service productService;

	    @GetMapping
	    public List<Product_model> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public Optional<Product_model> getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping
	    public Product_model saveProduct(@RequestBody Product_model product) {
	        return productService.saveProduct(product);
	    }

	    @PutMapping("/{id}")
	    public Product_model updateProduct(@PathVariable Long id, @RequestBody Product_model updatedProduct) {
	        Optional<Product_model> existingProduct = productService.getProductById(id);

	        if (existingProduct.isPresent()) {
	            Product_model product = existingProduct.get();
	            product.setName(updatedProduct.getName());
	            product.setDescription(updatedProduct.getDescription());
	            product.setPrice(updatedProduct.getPrice());

	            return productService.saveProduct(product);
	        } else {
	            throw new RuntimeException("Product not found with id: " + id);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.ok("Product with ID " + id + " deleted successfully");
	    }
	}
	

