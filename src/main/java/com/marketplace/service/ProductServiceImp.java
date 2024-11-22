package com.marketplace.service;

import com.marketplace.dto.ProductDTO;
import com.marketplace.dto.ProductMapper;
import com.marketplace.entity.Product;
import com.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    @Override
    public Optional<ProductDTO> findByName(String name) {
        return productRepository.findByName(name).map(productMapper::toDto);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(dto->productMapper.toDto(dto)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toEntity(productDTO));
        return productMapper.toDto(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDTO> update(Long id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(productInBD->{
                    productInBD.setName(productDTO.name());
                    productInBD.setDescription(productDTO.description());
                    productInBD.setPrice(productDTO.price());
                    productInBD.setCategory(productDTO.category());
                    productInBD.setAvailability(productDTO.availability());
                    productInBD.setImage(productDTO.image());
                    productInBD.setStatus(productDTO.status());
                    productInBD.setSalesman(productDTO.salesman());

                    return productRepository.save(productInBD);
                }).map(productMapper::toDto);
    }
}
