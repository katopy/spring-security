package com.spring_security.service;

import com.spring_security.dto.SaveProduct;
import com.spring_security.persistence.entity.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ProductService {

    // Focuses on what operations can be performed.
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    Product createOne(SaveProduct saveProduct);

    Product updateOneById(Long productId, SaveProduct saveProduct);
    Product disableOneById(Long productId);
}
