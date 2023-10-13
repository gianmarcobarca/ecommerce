package com.barca.ecommerce.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Document(collection = "products")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

  @Id
  String id;

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

  boolean active;

  @Field("created_date")
  @CreatedDate
  Instant createdDate;

  @Builder
  private static Product of(String name, String description, Set<String> category, BigDecimal unitPrice,
      int inventory) {

    return new Product(null, name, description, category, unitPrice, inventory,
        true, null);
  }

}
