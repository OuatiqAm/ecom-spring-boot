package com.para.paramiel.services;

import com.para.paramiel.entities.Category;

import java.util.List;

public interface CategoryService {

   List<Category> getAllCategories();
   Category addCategory(Category category);
   void deleteCategory(int id);
   Category updateCategory(Category category);
   Category findCategoryById(int id);


}
