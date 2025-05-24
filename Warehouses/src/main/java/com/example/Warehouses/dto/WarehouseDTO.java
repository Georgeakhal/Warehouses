package com.example.Warehouses.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class WarehouseDTO {
    private String name;
    private List<String> products_id;
    private List<String> shops_id;
}
