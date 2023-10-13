package com.barca.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.barca.ecommerce.dtos.ProductDto;
import com.barca.ecommerce.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

  Optional<ProductDto> findFirstById(String id);

  Page<ProductDto> findAllByCategory(String category, Pageable pageable);

  Page<ProductDto> findAllBy(Pageable pageable);
}
