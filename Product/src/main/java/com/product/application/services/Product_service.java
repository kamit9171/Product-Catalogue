package com.product.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.application.model.Product_model;
import com.product.application.repository.Product_Repository;

@Service
public class Product_service {
	
	
	    @Autowired
	    private Product_Repository productRepository;

	    public List<Product_model> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Optional<Product_model> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    public Product_model saveProduct(Product_model product) {
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	}

