package com.InventoryManagement.category_service.Controller;


import com.InventoryManagement.category_service.DTO.CategoryDTO;
import com.InventoryManagement.category_service.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.createCategory(dto);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        return service.updateCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAllCategories();
    }
}
