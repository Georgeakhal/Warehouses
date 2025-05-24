package com.example.Warehouses.repository;

import com.example.Warehouses.model.Product;
import com.example.Warehouses.model.Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
}
