package com.practice.movies.domain.usecase;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.domain.usecase.gateway.ICategoryRepository;
import com.practice.movies.infrastructure.entrypoint.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryUseCase {
    private ICategoryRepository iCategoryRepository;

    public CategoryUseCase(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public void save(Category category){
        iCategoryRepository.saveCategory(category);
    }
}
