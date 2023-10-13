package com.barca.ecommerce.dtos;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class ProductCreationDto {
  @NotNull
  String name;

  @NotNull
  @Size(min = 4, max = 300)
  String description;

  @NotEmpty
  Set<String> category;

  @NotNull
  @Field("unit_price")
  BigDecimal unitPrice;

  int inventory;
}
