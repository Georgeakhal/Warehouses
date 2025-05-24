package com.example.Warehouses.controller;

import com.example.Warehouses.dto.ProductDTO;
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

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ShopService shopService;
    private final WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        Warehouse warehouse = warehouseService.getWarehouse(dto.getWarehouse_id());
        Shop shop = shopService.getShop(dto.getShop_id());

        Product product = new Product();

        product.setId(UUID.randomUUID().toString());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setWarehouse(warehouse);
        product.setShop(shop);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
