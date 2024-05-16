package com.practice.movies.infrastructure.adapters.jpa.category;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.domain.model.category.CategoryId;
import com.practice.movies.domain.model.category.Name;
import com.practice.movies.domain.usecase.gateway.ICategoryRepository;
import com.practice.movies.infrastructure.adapters.jpa.entity.CategoryDbo;
import com.practice.movies.infrastructure.exceptionhandler.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CategoryAdapterRepository implements ICategoryRepository {

    public final ICategoryAdapterRepository repository;

    @Override
    public void saveCategory(Category category) {
        repository.save(CategoryDbo.fromDomain(category));
    }

    @Override
    public Category getCategory(Integer id) {
        Optional<CategoryDbo> categoryDbo = repository.findById(id);
        if (categoryDbo.isEmpty()){
            throw new BusinessException("No existe esa categoría careverga!");
        }
        return new Category(
                new CategoryId(categoryDbo.get().getId()),
                new Name(categoryDbo.get().getName())
        );
    }


}
