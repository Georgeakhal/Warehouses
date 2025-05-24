package com.example.Warehouses.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private String name;
    private int price;
    private int quantity;
    private String warehouse_id;
    private String shop_id;
}
