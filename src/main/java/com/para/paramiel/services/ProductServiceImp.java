package com.para.paramiel.services;

import com.para.paramiel.entities.Product;
import com.para.paramiel.exceptions.ItemsNotFoundException;
import com.para.paramiel.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product findProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> findProductsByCategoryId(int id) {
        return productRepository.getProductByCategoryId(id);
    }

    @Override
    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }



    @Override
    public Product addProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public List<Product> findProductsByCategoryName(String categoryName) {
        List<Product> products = productRepository.getProductsByCategoryName(categoryName);
        if(products == null) throw new ItemsNotFoundException("Products not found");
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


}
