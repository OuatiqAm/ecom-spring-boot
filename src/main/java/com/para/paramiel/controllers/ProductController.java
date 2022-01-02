package com.para.paramiel.controllers;

import com.para.paramiel.dtos.product.ProductResponseDto;
import com.para.paramiel.dtos.product.ProductRequestDto;
import com.para.paramiel.entities.Category;
import com.para.paramiel.entities.Product;
import com.para.paramiel.exceptions.ItemsNotFoundException;
import com.para.paramiel.services.CategoryService;
import com.para.paramiel.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productRequestDto){
        ModelMapper mapper = new ModelMapper();
        Product product = mapper.map(productRequestDto, Product.class);
        System.out.println(productRequestDto);
        Product newProduct = productService.addProduct(product);
        ProductResponseDto productGet = mapper.map(newProduct, ProductResponseDto.class);
       return new ResponseEntity<ProductResponseDto>(productGet, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable(value = "id") int id, @RequestBody ProductRequestDto request){
        Product product = productService.findProductById(id);
        if(product == null) throw new NullPointerException("product not found");

        String name = request.getName();
        if(name == null ) throw new NullPointerException("Product name is null");
        product.setName(name);

        String sku = request.getSkuCode();
        if(sku == null ) throw new NullPointerException("Product SKU is null");
        product.setSkuCode(sku);

        String description = request.getDescription();
        if(description == null ) throw new NullPointerException("Product description is null");
        product.setDescription(description);

        Category category = request.getCategory();
        if(category == null ) throw new NullPointerException("Product category is null");
        product.setCategory(category);

        BigDecimal price = request.getPrice();
        if(price == null ) throw new NullPointerException("Product price is null");
        product.setPrice(price);

        Integer quantity = request.getQuantity();
        if(quantity == null ) throw new NullPointerException("Product quantity is null");
        product.setQuantity(quantity);

       //we need update media here also

        Product newProduct = productService.updateProduct(product);
        ModelMapper mapper=new ModelMapper();
        ProductResponseDto productResponseDto = mapper.map(newProduct, ProductResponseDto.class);
        return new ResponseEntity<ProductResponseDto>(productResponseDto, HttpStatus.ACCEPTED);
    }


    @GetMapping(value= {"/cat/{cat}"})
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryName(@PathVariable(value = "cat")String categoryName){
        List<Product> products = productService.findProductsByCategoryName(categoryName);
        ModelMapper mapper = new ModelMapper();
        List<ProductResponseDto> productsGetDto = products.stream().map(p -> mapper.map(p, ProductResponseDto.class)).collect(Collectors.toList());
    return new ResponseEntity<List<ProductResponseDto>>(productsGetDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        List<Product> products = productService.findAllProduct();
        List<ProductResponseDto> productsGetDto = products.stream().map(product -> new ModelMapper().map(product, ProductResponseDto.class)).collect(Collectors.toList());
      return  new ResponseEntity<List<ProductResponseDto>>(productsGetDto,HttpStatus.OK);
    }

    @GetMapping(value= {"/cat_id/{id}"})
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(@PathVariable(value = "id")int id){
        List<Product> products = productService.findProductsByCategoryId(id);
        ModelMapper mapper = new ModelMapper();
        List<ProductResponseDto> productsGetDto = products.stream().map(p -> mapper.map(p, ProductResponseDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<ProductResponseDto>>(productsGetDto,HttpStatus.OK);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable(value = "id") int id){
        Product product = productService.findProductById(id);
        ModelMapper mapper = new ModelMapper();
        ProductResponseDto productResponseDto = mapper.map(product, ProductResponseDto.class);
        return  new ResponseEntity<ProductResponseDto>(productResponseDto,HttpStatus.OK);
    }


}
