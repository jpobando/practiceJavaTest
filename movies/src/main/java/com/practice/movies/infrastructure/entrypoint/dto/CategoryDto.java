package com.practice.movies.infrastructure.entrypoint.dto;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.domain.model.category.CategoryId;
import com.practice.movies.domain.model.category.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CategoryDto {
    private Integer id;
    private String name;

    public static Category toDomain(CategoryDto categoryDto){
        return new Category(
                new CategoryId(categoryDto.getId()),
                new Name(categoryDto.getName())
        );
    }
    public static CategoryDto fromDomain(Category category){
        return new CategoryDto(
                category.getCategoryId().getValue(),
                category.getName().getValue()
        );
    }
}

