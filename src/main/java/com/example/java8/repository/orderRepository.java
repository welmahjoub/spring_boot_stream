package com.example.java8.repository;

import com.example.java8.entity.Order;
import com.example.java8.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface orderRepository extends CrudRepository<Order, Long> {

}