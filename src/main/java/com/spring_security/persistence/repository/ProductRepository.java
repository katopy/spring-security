package com.spring_security.persistence.repository;

import com.spring_security.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Wrapping generics. The entity type and the type of entity's id
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
