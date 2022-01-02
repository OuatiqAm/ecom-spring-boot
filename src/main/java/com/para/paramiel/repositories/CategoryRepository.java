package com.para.paramiel.repositories;

import com.para.paramiel.entities.Category;
import com.para.paramiel.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
        @Query("Select c  from Category as c where c.name =: name")
        Category getCategoryByName(@Param(value="name") String name);

}
