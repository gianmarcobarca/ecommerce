package com.barca.ecommerce.dtos;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Value;

@Value
public class ProductDto {

  String id;
  String name;
  String description;
  Set<String> category;
  BigDecimal unitPrice;
  int inventory;
}
