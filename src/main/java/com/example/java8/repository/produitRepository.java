package com.example.java8.repository;

import com.example.java8.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface produitRepository extends CrudRepository<Product, Long> {

}