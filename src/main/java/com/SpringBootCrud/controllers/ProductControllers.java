package com.SpringBootCrud.controllers;

import com.SpringBootCrud.models.Product;
import com.SpringBootCrud.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/products")
public class ProductControllers {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<Product> list() {
        return productsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productOptional = productsService.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product>create(@RequestBody Product product){
        return  ResponseEntity.status(HttpStatus.CREATED).body( productsService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product product){
        Optional<Product> productOptional = productsService.update(id, product);
        if (productOptional.isPresent()) {
            return  ResponseEntity.status(HttpStatus.CREATED).body( productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Product> productOptional = productsService.delete(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}

