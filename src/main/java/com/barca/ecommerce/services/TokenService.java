package com.barca.ecommerce.services;

import com.barca.ecommerce.dtos.JwtDto;
import com.barca.ecommerce.security.CustomUserDetails;

public interface TokenService {

  JwtDto createToken(CustomUserDetails userDetails);

}
