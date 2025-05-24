package com.example.Warehouses.repository;

import com.example.Warehouses.model.Product;
import com.example.Warehouses.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
}
