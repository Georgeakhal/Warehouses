package com.example.Warehouses.service;

import com.example.Warehouses.model.Product;
import com.example.Warehouses.model.Shop;
import com.example.Warehouses.repository.ProductRepository;
import com.example.Warehouses.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShopService {

    private final ShopRepository repository;

    public List<Shop> getAll(){
        return repository.findAll();
    }

    public Shop getShop(String id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Shop found with id: " + id));
    }

    public Shop save(Shop shop){
        return repository.save(shop);
    }

    public void update(String id, Shop shop) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No Shop found with id: " + id);
        }
        repository.save(shop);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
