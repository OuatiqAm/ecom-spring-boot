package com.para.paramiel.repositories;


import com.para.paramiel.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

    @Query("Select p from Product as p where p.id = :id")
    Product getProductById(Integer id);

    @Query("Select p from Product as p where p.category.id = :id")
    List<Product> getProductByCategoryId(@Param(value ="id")Integer id);


    @Query("Select p from Product as p join p.category as c where c.name = :name")
    List<Product> getProductsByCategoryName(@Param(value ="name") String categoryName);

}
