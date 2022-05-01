package com.ks.community.repository;

import com.ks.community.entity.User;
import com.ks.community.repository.jpainterface.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {
  private final UserInterface userInterface;

  public User insert(User user){
    return userInterface.save(user);
  }

  public Optional<User> getUserById(long id) {
    return userInterface.findById(id);
  }
}
