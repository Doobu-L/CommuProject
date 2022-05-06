package com.ks.community.dto;

import com.ks.community.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserDto {
  private long id;
  private String userId;
  private String password;
  private String nickname;

  public UserDto(User user){
    this.id = user.getId();
    this.userId = user.getUserId();
    this.password = user.getPassword();
    this.nickname = user.getNickname();

  }
}
