package com.InventoryManagement.product_service.Service;

import com.InventoryManagement.product_service.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategory(Long categoryId);
    List<ProductDTO> getProductsBySupplier(Long supplierId);
    void reduceStock(Long productId, int quantity);
    void increaseStock(Long productId, int quantity);
}
