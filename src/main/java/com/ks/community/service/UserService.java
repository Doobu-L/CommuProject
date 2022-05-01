package com.ks.community.service;

import com.ks.community.dto.UserDto;
import com.ks.community.entity.User;
import com.ks.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public UserDto newUser(UserDto user) {
    return new UserDto(userRepository.insert(new User(user)));
  }


  public UserDto getUserById(long id) {
    //Todo Custom ExceptionHandle
    UserDto user = userRepository.getUserById(id).map(UserDto::new).orElseThrow(RuntimeException::new);
    return user;
  }
}
