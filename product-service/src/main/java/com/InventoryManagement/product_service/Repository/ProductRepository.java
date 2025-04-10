package com.InventoryManagement.product_service.Repository;

import com.InventoryManagement.product_service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryId(Long categoryId);
    List<Product> findBySupplierId(Long supplierId);

}
