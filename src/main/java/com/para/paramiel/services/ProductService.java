package com.para.paramiel.services;


import com.para.paramiel.entities.Product;

import java.util.List;

public interface ProductService {

  
    Product findProductById(int id);

    List<Product> findProductsByCategoryId(int id);

    List<Product> findAllProduct();


    Product addProduct(Product p);

    List<Product> findProductsByCategoryName(String categoryName);

    Product updateProduct(Product product);

}
