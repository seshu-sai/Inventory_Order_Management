package com.InventoryManagement.category_service.Service;

import com.InventoryManagement.category_service.DTO.CategoryDTO;
import com.InventoryManagement.category_service.Model.Category;
import com.InventoryManagement.category_service.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = modelMapper.map(dto, Category.class);
        return modelMapper.map(repository.save(category), CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return modelMapper.map(repository.save(category), CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return repository.findById(id)
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(cat -> modelMapper.map(cat, CategoryDTO.class))
                .collect(Collectors.toList());
    }
}
