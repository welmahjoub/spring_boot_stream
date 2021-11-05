package com.example.java8.entity;

import com.example.java8.entity.Order;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private String category;
  private Double price;
  
  @ManyToMany(mappedBy = "products")
  @ToString.Exclude
  private Set<Order> orders;
}