package com.barca.ecommerce.dtos;

import com.barca.ecommerce.models.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class UserCreationDto {

  @NotNull
  @Size(min = 1, max = 50)
  String firstName;

  @NotNull
  @Size(min = 1, max = 50)
  String lastName;

  @NotNull
  Address address;

  @NotNull
  @Size(min = 6, max = 50)
  @Email
  String email;

  @NotNull
  @Size(min = 8, max = 24)
  String password;
}
