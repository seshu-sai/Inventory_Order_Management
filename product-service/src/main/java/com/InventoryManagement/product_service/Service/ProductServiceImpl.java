package com.InventoryManagement.product_service.Service;

import com.InventoryManagement.product_service.DTO.ProductDTO;
import com.InventoryManagement.product_service.ExceptionHandling.ResourceNotFoundException;
import com.InventoryManagement.product_service.Model.Product;
import com.InventoryManagement.product_service.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product saved = productRepository.save(product);
        return modelMapper.map(saved, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCategoryId(productDTO.getCategoryId());
        product.setSupplierId(productDTO.getSupplierId());
        Product updated = productRepository.save(product);
        return modelMapper.map(updated, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsBySupplier(Long supplierId) {
        return productRepository.findBySupplierId(supplierId)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void reduceStock(Long productId, int quantity) {
        Product product = productRepository.findById(Math.toIntExact(productId))
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for product ID: " + productId);
        }
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }

    @Override
    public void increaseStock(Long productId, int quantity) {
        Product product = productRepository.findById(Math.toIntExact(productId))
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        product.setStock(product.getStock() + quantity);
        productRepository.save(product);
    }
}
