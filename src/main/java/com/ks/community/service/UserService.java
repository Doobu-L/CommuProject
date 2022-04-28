package com.ks.community.service;

import com.ks.community.dto.UserDto;
import com.ks.community.entity.User;
import com.ks.community.repository.UserRepository;
import com.ks.community.response.BaseResponse;
import lombok.RequiredArgsConstructor;;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public BaseResponse newUser(UserDto user){
    return userRepository.save(new User(user)) != null ?
        new BaseResponse()
        : new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST.name());
  }


}
