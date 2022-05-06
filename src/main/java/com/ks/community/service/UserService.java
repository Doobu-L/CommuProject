package com.ks.community.service;

import com.ks.community.dto.UserDto;
import com.ks.community.entity.User;
import com.ks.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public UserDto newUser(UserDto user) {
    return new UserDto(userRepository.insert(new User(user)));
  }


  @Transactional
  public User getUserById(long id) {
    //Todo Custom ExceptionHandle
    User user = userRepository.getUserById(id).orElseThrow(RuntimeException::new);
    return user;
  }

  @Transactional
  public boolean updateUser(long id, UserDto req) throws Exception {
    User user = userRepository.getUserById(id).orElseThrow(NotFoundException::new);

    if(StringUtils.isNotBlank(req.getNickname()))user.setNickname(req.getNickname());
    if(StringUtils.isNotBlank(req.getPassword()))user.setPassword(req.getPassword());
    return true;
  }
}
