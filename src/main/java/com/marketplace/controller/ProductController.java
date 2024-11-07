package com.marketplace.controller;

import com.marketplace.dto.ProductDTO;
import com.marketplace.exceptions.NotFoundException;
import com.marketplace.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.save(productDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.update(id, productDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (!productService.existsById(id)) {
            throw new NotFoundException("Product with id " + id + " not found");
        }
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
        return productService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product with name '" + name + "' not found"));
    }
}
