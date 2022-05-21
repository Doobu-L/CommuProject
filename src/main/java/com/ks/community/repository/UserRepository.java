package com.ks.community.repository;

import com.ks.community.domain.entity.User;
import com.ks.community.repository.jpainterface.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository  {
  private final UserInterface userInterface;

  public User insert(User user){
    return userInterface.save(user);
  }

  public boolean validUser(User user){
    //아이디 중복
    if(userInterface.findByUserId(user.getUserId()).isPresent())
      throw new RuntimeException(); //Todo CustomException Message

    return true;
  }

  public Optional<User> getUserById(long id) {
    return userInterface.findById(id);
  }

  public Optional<User> findByEmail(String email){
    return userInterface.findByEmail(email);
  }

  public User save(User user) {
    return userInterface.save(user);
  }

  public boolean checkNickname(String nickname){
    return userInterface.findByNickname(nickname).isPresent()?true:false;
  }
}
