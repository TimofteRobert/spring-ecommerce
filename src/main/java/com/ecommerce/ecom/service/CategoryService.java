package com.ecommerce.ecom.service;

import com.ecommerce.ecom.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    Category updateCategory(Category category, Long categoryId);

    String deleteCategory(Long categoryId);
}
