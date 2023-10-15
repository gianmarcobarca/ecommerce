package com.barca.ecommerce.models;

import java.util.Collections;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Document(collection = "users")
@Value
public class User { // final access will cause performance loss

  @Id
  String id;

  @Field("first_name")
  @Size(min = 1, max = 50)
  @NotNull
  String firstName;

  @Field("last_name")
  @NotNull
  @Size(min = 1, max = 50)
  String lastName;

  @NotNull
  Address address;

  @Indexed(unique = true)
  @NotNull
  @Size(min = 6, max = 50)
  @Email
  String email;

  @NotNull
  @Size(min = 8, max = 256)
  String password;

  @NotNull
  Set<String> authorities;

  private User( // private access will cause performance loss
      String id,
      String firstName,
      String lastName,
      Address address,
      String email,
      String password,
      Set<String> authorities) {

    this.id = id;
    this.firstName = firstName.toLowerCase().trim();
    this.lastName = lastName.toLowerCase().trim();
    this.address = address;
    this.email = email.toLowerCase();
    this.password = password;
    this.authorities = authorities;
  }

  @Builder
  private static User of(
      String firstName,
      String lastName,
      Address address,
      String email,
      String password) {

    return new User(
        null,
        firstName,
        lastName,
        address,
        email,
        password,
        Collections.emptySet());
  }
}
