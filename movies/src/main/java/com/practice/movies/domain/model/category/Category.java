package com.practice.movies.domain.model.category;

public class Category {
    private final CategoryId categoryId;
    private final Name name;

    public Category(CategoryId categoryId, Name name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public Name getName() {
        return name;
    }
}
