package com.InventoryManagement.category_service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
    @Table(name = "categories")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;

}
