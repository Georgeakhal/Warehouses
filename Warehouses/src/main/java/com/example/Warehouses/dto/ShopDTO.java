package com.example.Warehouses.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ShopDTO {
    private String name;
    private List<String> products_id;
    private List<String> warehouses_id;
}
