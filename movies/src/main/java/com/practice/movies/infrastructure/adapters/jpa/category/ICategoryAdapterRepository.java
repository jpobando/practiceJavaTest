package com.practice.movies.infrastructure.adapters.jpa.category;

import com.practice.movies.infrastructure.adapters.jpa.entity.CategoryDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryAdapterRepository extends JpaRepository<CategoryDbo, Integer> {
}
