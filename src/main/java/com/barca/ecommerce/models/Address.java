package com.barca.ecommerce.models;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Address {

  @Field(name = "street_name")
  @Size(min = 1, max = 40)
  String streetName;

  @Size(min = 1, max = 28)
  String city;

  @Size(min = 4, max = 14)
  String state;

  @Field(name = "zip_code")
  @Size(min = 9, max = 9)
  String zipCode;

}
