package com.para.paramiel.controllers;

import com.para.paramiel.dtos.category.CategoryGetDto;
import com.para.paramiel.dtos.category.CategoryPostDto;
import com.para.paramiel.dtos.category.CategoryPutDto;
import com.para.paramiel.entities.Category;
import com.para.paramiel.exceptions.ItemsNotFoundException;

import com.para.paramiel.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryGetDto> addCategory(@RequestBody CategoryPostDto categoryPostDto) {
        ModelMapper mapper = new ModelMapper();
        Category category = mapper.map(categoryPostDto, Category.class);
        Category newCategory = categoryService.addCategory(category);
        CategoryGetDto categoryGetDto = mapper.map(newCategory, CategoryGetDto.class);
        return new ResponseEntity<CategoryGetDto>(categoryGetDto,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryGetDto>> findAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        ModelMapper mapper = new ModelMapper();
        List<CategoryGetDto> categoriesGetDto = categories.stream().map(c -> new ModelMapper().map(c, CategoryGetDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<CategoryGetDto>>(categoriesGetDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryGetDto> updateCategory(@PathVariable(value = "id") int id, @RequestBody  CategoryPutDto categoryPutDto){
        Category category = categoryService.findCategoryById(id);
        if(category == null) throw new ItemsNotFoundException("category not found");
        String name = categoryPutDto.getName();
        if(name == null ) throw new NullPointerException("Category name is null");
        category.setName(categoryPutDto.getName());
        Category newCategory = categoryService.updateCategory(category);
        ModelMapper mapper=new ModelMapper();
        CategoryGetDto categoryGetDto = mapper.map(newCategory, CategoryGetDto.class);
        return new ResponseEntity<CategoryGetDto>(categoryGetDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
