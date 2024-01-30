package com.spring.authproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.authproject.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
