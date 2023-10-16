package com.barca.ecommerce.controllers;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barca.ecommerce.annotations.Principal;
import com.barca.ecommerce.dtos.UserCartDto;
import com.barca.ecommerce.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController("cartController")
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

  private final UserService userService;

  @GetMapping
  public UserCartDto getCart(@Principal Jwt jwt) {
    return userService.getUserCart(jwt.getSubject());

  }
}
