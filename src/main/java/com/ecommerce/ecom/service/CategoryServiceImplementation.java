package com.ecommerce.ecom.service;

import com.ecommerce.ecom.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category existingCategory = categories.stream().filter(c -> c.getCategoryId()
                .equals(categoryId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id: " + categoryId + " not found."));

            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categories.remove(category);
        return "Category with categoryId: " + categoryId + " has been deleted.";
    }
}
