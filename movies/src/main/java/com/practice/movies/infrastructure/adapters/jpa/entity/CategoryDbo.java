package com.practice.movies.infrastructure.adapters.jpa.entity;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.domain.model.category.Name;
import com.practice.movies.domain.model.category.CategoryId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="category")
public class CategoryDbo {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public static CategoryDbo fromDomain(Category category){
        return new CategoryDbo(
                null,
                category.getName().getValue()
        );
    }

    public static Category toDomain(CategoryDbo categoryDbo){
        return new Category(
            new CategoryId(categoryDbo.getId()),
            new Name(categoryDbo.getName())
        );
    }


}
