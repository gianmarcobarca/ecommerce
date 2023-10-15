package com.barca.ecommerce.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barca.ecommerce.annotations.Principal;
import com.barca.ecommerce.dtos.JwtDto;
import com.barca.ecommerce.dtos.UserCreationDto;
import com.barca.ecommerce.security.CustomUserDetails;
import com.barca.ecommerce.services.TokenService;
import com.barca.ecommerce.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController("authController")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final TokenService tokenService;
  private final UserService userService;

  @GetMapping("/token")
  public JwtDto getToken(@Principal UserDetails userDetails) {
    return tokenService.createToken((CustomUserDetails) userDetails);
  }

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public void signup(@RequestBody @Valid UserCreationDto dto) {
    userService.createUser(dto);
  }

  // TODO changePassword

  @DeleteMapping("/deregister")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deregister(@Principal UserDetails userDetails) {
    userService.deleteUser(((CustomUserDetails) userDetails).getId());
  }

}
