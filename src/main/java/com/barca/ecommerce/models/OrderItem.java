package com.barca.ecommerce.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class OrderItem {

  @Id
  String id;

  @Field(name = "unit_price")
  BigDecimal unitPrice;

  int quantity;

  @Field(name = "product_id")
  String productId;
}
