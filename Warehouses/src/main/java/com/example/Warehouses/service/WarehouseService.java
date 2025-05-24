package com.example.Warehouses.service;


import com.example.Warehouses.model.Shop;
import com.example.Warehouses.model.Warehouse;
import com.example.Warehouses.repository.ShopRepository;
import com.example.Warehouses.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository repository;

    public List<Warehouse> getAll(){
        return repository.findAll();
    }

    public Warehouse getWarehouse(String id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Warehouse found with id: " + id));
    }

    public Warehouse save(Warehouse warehouse){
        return repository.save(warehouse);
    }

    public void update(String id, Warehouse warehouse) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No Warehouse found with id: " + id);
        }
        repository.save(warehouse);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
