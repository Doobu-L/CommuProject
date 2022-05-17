package com.ks.community.User;

import com.ks.community.dto.UserDto;
import com.ks.community.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

  @Autowired
  UserService userService;

  @Test
  public void 유저_신규(){
    String userId = "아이디";
    String password = "패스워드";
    String nickname = "닉네임";
    String username = "이름";

    UserDto req = UserDto.builder()
        .userId(userId)
        .username(username)
        .password(password)
        .nickname(nickname)
        .build();

    UserDto userDto = userService.newUser(req);

    assertThat(userDto.getUserId()).isEqualTo(userId);
    assertThat(userDto.getPassword()).isEqualTo(password);
    assertThat(userDto.getNickname()).isEqualTo(nickname);
    assertThat(userDto.getUsername()).isEqualTo(username);

  }


}
