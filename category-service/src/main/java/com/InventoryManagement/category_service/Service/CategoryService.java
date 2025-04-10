package com.InventoryManagement.category_service.Service;

import com.InventoryManagement.category_service.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO dto);
    CategoryDTO updateCategory(Long id, CategoryDTO dto);
    void deleteCategory(Long id);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
}
