package com.practice.movies.infrastructure.entrypoint;

import com.practice.movies.domain.usecase.CategoryUseCase;
import com.practice.movies.infrastructure.entrypoint.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryEntryPoint {
    private final CategoryUseCase categoryUseCase;

    @PostMapping
    public void saveCategory(@RequestBody CategoryDto categoryDto){
        categoryUseCase.save(CategoryDto.toDomain(categoryDto));
    }
}
