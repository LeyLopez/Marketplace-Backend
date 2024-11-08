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
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
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
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id) {
        return productService.findById(id).map(p->{
            productService.delete(id);
            return ResponseEntity.ok().body(p);
        }).orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
        return productService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Product with name '" + name + "' not found"));
    }
}
