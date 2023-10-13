package com.barca.ecommerce.services.internal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barca.ecommerce.dtos.ProductCreationDto;
import com.barca.ecommerce.dtos.ProductDto;
import com.barca.ecommerce.models.Product;
import com.barca.ecommerce.repositories.ProductRepository;
import com.barca.ecommerce.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public void createProduct(ProductCreationDto dto) {

    Product product = Product.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .category(dto.getCategory())
        .unitPrice(dto.getUnitPrice())
        .inventory(dto.getInventory())
        .build();

    productRepository.save(product);
  }

  @Override
  public ProductDto getProduct(String productId) {
    return productRepository.findFirstById(productId).orElseThrow();
  }

  @Override
  public Page<ProductDto> getProductsByCategory(String catergory, Pageable pageable) {
    return productRepository.findAllByCategory(catergory, pageable);
  }

  @Override
  public Page<ProductDto> getProducts(Pageable pageable) {
    return productRepository.findAllBy(pageable);
  }

}
