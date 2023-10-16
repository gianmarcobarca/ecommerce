package com.barca.ecommerce.services.internal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.barca.ecommerce.dtos.UserCartDto;
import com.barca.ecommerce.dtos.UserCreationDto;
import com.barca.ecommerce.models.User;
import com.barca.ecommerce.repositories.UserRepository;
import com.barca.ecommerce.security.UserDetailsImpl;
import com.barca.ecommerce.services.UserService;

import lombok.RequiredArgsConstructor;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new UserDetailsImpl(userRepository.findByEmail(username).orElseThrow());
  }

  @Override
  public void createUser(UserCreationDto dto) {

    var copy = User
        .builder()
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .address(dto.getAddress())
        .email(dto.getEmail())
        .password(passwordEncoder.encode(dto.getPassword()))
        .build();

    userRepository.save(copy);
  }

  @Override
  public void deleteUser(String userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public UserCartDto getUserCart(String id) {
    return userRepository.findFirstById(id);
  }
}
