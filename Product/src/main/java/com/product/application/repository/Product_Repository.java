package com.product.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.application.model.Product_model;


@Repository

public interface Product_Repository  extends JpaRepository<Product_model, Long> {
}


