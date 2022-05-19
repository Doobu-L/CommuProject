package com.ks.community.domain.dto;

import com.ks.community.domain.entity.User;
import lombok.Builder;
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
  private String username;

  public UserDto(User user){
    this.id = user.getId();
    this.userId = user.getUserId();
    this.password = user.getPassword();
    this.nickname = user.getNickname();
    this.username = user.getUsername();
  }

  @Builder
  public UserDto(String userId,String password, String nickname, String username){
    this.userId = userId;
    this.password = password;
    this.nickname = nickname;
    this.username = username;
  }
}
