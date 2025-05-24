package com.example.Warehouses.service;

import com.example.Warehouses.model.Product;
import com.example.Warehouses.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getProduct(String id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Product found with id: " + id));
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public void update(String id, Product product) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No Product found with id: " + id);
        }
        repository.save(product);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
