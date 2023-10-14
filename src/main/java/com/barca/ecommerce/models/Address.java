package com.barca.ecommerce.models;

import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class Address {

  @Size(min = 1, max = 40)
  String streetName;

  @Size(min = 1, max = 28)
  String city;

  @Size(min = 4, max = 14)
  String state;

  @Size(min = 9, max = 9)
  String zipCode;

}
