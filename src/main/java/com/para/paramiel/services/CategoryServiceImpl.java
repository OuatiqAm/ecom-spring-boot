package com.para.paramiel.services;

import com.para.paramiel.entities.Category;
import com.para.paramiel.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {

        Category newCategory = categoryRepository.save(category);
        return newCategory;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }
}
