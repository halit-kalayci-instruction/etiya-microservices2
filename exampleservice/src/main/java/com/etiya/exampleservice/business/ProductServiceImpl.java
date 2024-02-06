package com.etiya.exampleservice.business;

import com.etiya.exampleservice.dtos.AddProductRequest;
import com.etiya.exampleservice.entities.Product;
import com.etiya.exampleservice.logging.FileLogger;
import com.etiya.exampleservice.logging.ILogger;
import com.etiya.exampleservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public void add(AddProductRequest request) {
        // Red-Green-Refactor
        if(productRepository.findProductByName(request.getName()).isPresent())
        {
            throw new RuntimeException("");
        }
        Product product = new Product();
        product.setName(request.getName());
        productRepository.save(product);
    }
}
