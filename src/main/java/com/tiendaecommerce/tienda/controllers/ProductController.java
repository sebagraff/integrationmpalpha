package com.tiendaecommerce.tienda.controllers;

import com.tiendaecommerce.tienda.dtos.ProductDTO;
import com.tiendaecommerce.tienda.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<ProductDTO> getAll(){
        return this.productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
