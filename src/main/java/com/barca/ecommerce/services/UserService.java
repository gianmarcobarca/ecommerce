package com.barca.ecommerce.services;

import com.barca.ecommerce.dtos.UserCartDto;
import com.barca.ecommerce.dtos.UserCreationDto;

public interface UserService {
  void createUser(UserCreationDto dto);

  void deleteUser(String userId);

  UserCartDto getUserCart(String id);
}
