package com.practice.movies.domain.usecase.gateway;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.infrastructure.entrypoint.dto.CategoryDto;
import org.springframework.stereotype.Repository;
public interface ICategoryRepository {
    void saveCategory(Category category);

    Category getCategory(Integer id);


}
