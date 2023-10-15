package com.barca.ecommerce.controllers;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barca.ecommerce.dtos.ProductCreationDto;
import com.barca.ecommerce.dtos.ProductDto;
import com.barca.ecommerce.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController("productController")
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{productId}")
  public ProductDto getProduct(@PathVariable String productId) {
    return productService.getProduct(productId);

  }

  @GetMapping
  public Page<ProductDto> getProducts(@RequestParam(required = false) Optional<String> category, Pageable pageable) {
    category.ifPresent(cat -> productService.getProductsByCategory(cat, pageable));
    return productService.getProducts(pageable);
  }

  // TODO: only admins should have access
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody @Valid ProductCreationDto dto) {
    // TODO add location header
    productService.createProduct(dto);
  }
}
