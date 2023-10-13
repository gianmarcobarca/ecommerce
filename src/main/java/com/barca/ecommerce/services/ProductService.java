package com.barca.ecommerce.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.barca.ecommerce.dtos.ProductCreationDto;
import com.barca.ecommerce.dtos.ProductDto;

public interface ProductService {

  void createProduct(ProductCreationDto dto);

  ProductDto getProduct(String productId);

  Page<ProductDto> getProductsByCategory(String catergory, Pageable pageable);

  Page<ProductDto> getProducts(Pageable pageable);
}
