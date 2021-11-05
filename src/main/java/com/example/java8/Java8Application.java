package com.example.java8;

import com.example.java8.entity.Order;
import com.example.java8.entity.Product;
import com.example.java8.repository.orderRepository;
import com.example.java8.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.*;

@SpringBootApplication
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }


    @Autowired
    produitRepository productRepo;
    @Autowired
    orderRepository orderRepo;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("herer");
        //        productRepo.findAll().forEach( System.out::println);

        // 1. Obtenir une liste de produits appartient à la catégorie « Livres » avec un prix > 100

        Stream<Product> produits = StreamSupport.stream(productRepo.findAll().spliterator(), false);

        produits.
                filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 100)
                .forEach( System.out::println);


      Stream<Order> orders = StreamSupport.stream(orderRepo.findAll().spliterator(), false);
//
//
//        //2 . Obtenir une liste de commande avec des produits appartenant à la catégorie « Bébé »
        orders
                .filter(o ->
                        o.getProducts()
                                .stream()
                                .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
                )
                .forEach( System.out::println);

        // 3.
    }


}
