package com.example.Warehouses.controller;


import com.example.Warehouses.dto.ProductDTO;
import com.example.Warehouses.dto.ShopDTO;
import com.example.Warehouses.dto.WarehouseDTO;
import com.example.Warehouses.model.Product;
import com.example.Warehouses.model.Shop;
import com.example.Warehouses.model.Warehouse;
import com.example.Warehouses.service.ProductService;
import com.example.Warehouses.service.ShopService;
import com.example.Warehouses.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final ProductService productService;
    private final ShopService shopService;
    private final WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAll(){
        return ResponseEntity.ok(warehouseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable String id){
        return ResponseEntity.ok(warehouseService.getWarehouse(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Warehouse> create(@RequestBody WarehouseDTO dto){

        Warehouse warehouse = new Warehouse();

        if (dto.getProducts_id() != null && dto.getShops_id() != null && !dto.getShops_id().isEmpty() && !dto.getProducts_id().isEmpty()) {
            List<Product> products = new ArrayList<>();
            List<Shop> shops = new ArrayList<>();

            for (String id : dto.getProducts_id()){
                products.add(productService.getProduct(id));
            }

            for (String id : dto.getShops_id()){
                shops.add(shopService.getShop(id));
            }

            warehouse.setProducts(products);
            warehouse.setShops(shops);
        }

        warehouse.setId(UUID.randomUUID().toString());
        warehouse.setName(dto.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(warehouseService.save(warehouse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        warehouseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
