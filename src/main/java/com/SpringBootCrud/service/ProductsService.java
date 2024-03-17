package com.SpringBootCrud.service;

import com.SpringBootCrud.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> delete(Long id);
}
