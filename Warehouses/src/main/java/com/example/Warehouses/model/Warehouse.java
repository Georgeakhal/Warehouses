package com.example.Warehouses.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Warehouse")
@Getter
@Setter
public class Warehouse {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "warehouse")
    private List<Product> products;

    @JsonBackReference
    @ManyToMany(mappedBy = "warehouses")
    private List<Shop> shops;
}

