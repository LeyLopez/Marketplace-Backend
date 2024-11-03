package com.marketplace.service;

import com.marketplace.dto.CategoryDTO;
import com.marketplace.dto.CategoryMapper;
import com.marketplace.entity.Category;
import com.marketplace.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::toDto);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(dto->categoryMapper.toDto(dto))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(categoryMapper.toEntity(categoryDTO));
        return categoryMapper.toDto(category);
    }

    @Override
    public Optional<CategoryDTO> update(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .map(categoryInBD->{
                    categoryInBD.setName(categoryDTO.name());

                    return categoryRepository.save(categoryInBD);

        }).map(categoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<CategoryDTO> findByName(String name) {
        return categoryRepository.findByName(name).map(categoryMapper::toDto);
    }
}
