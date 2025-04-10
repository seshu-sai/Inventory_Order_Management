package com.InventoryManagement.category_service.Repository;


import com.InventoryManagement.category_service.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

