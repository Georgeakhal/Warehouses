package com.example.Warehouses.controller;

import com.example.Warehouses.dto.ProductDTO;
import com.example.Warehouses.dto.ShopDTO;
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
@RequestMapping("/shop")
public class ShopController {
    private final ProductService productService;
    private final ShopService shopService;
    private final WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<Shop>> getAll(){
        return ResponseEntity.ok(shopService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getProduct(@PathVariable String id){
        return ResponseEntity.ok(shopService.getShop(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Shop> create(@RequestBody ShopDTO dto){
        Shop shop = new Shop();

        if (!dto.getWarehouses_id().isEmpty() || !dto.getProducts_id().isEmpty()){
            List<Product> products = new ArrayList<>();
            List<Warehouse> warehouses = new ArrayList<>();

            for (String id : dto.getProducts_id()){
                products.add(productService.getProduct(id));
            }

            for (String id : dto.getWarehouses_id()){
                warehouses.add(warehouseService.getWarehouse(id));
            }

            shop.setProducts(products);
            shop.setWarehouses(warehouses);
        }

        shop.setId(UUID.randomUUID().toString());
        shop.setName(dto.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(shopService.save(shop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        shopService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
