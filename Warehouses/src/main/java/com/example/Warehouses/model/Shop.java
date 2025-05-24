package com.example.Warehouses.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Shop")
@Getter
@Setter
public class Shop {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "shop")
    private List<Product> products;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "shop_warehouse",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouse_id")
    )
    private List<Warehouse> warehouses;
}

