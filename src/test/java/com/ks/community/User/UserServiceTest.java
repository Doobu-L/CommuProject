package com.ks.community.User;

import com.ks.community.domain.dto.UserDto;
import com.ks.community.domain.entity.User;
import com.ks.community.service.UserService;
import org.apache.commons.lang3.StringUtils;
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
    String userId = "poitt";
    String password = "passw";
    String nickname = "날룰루";
    String username = "부우자";

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

    System.out.printf("User insert Success");
  }

  @Test
  public void 유저_수정() throws Exception {
    long id = 3L;
    String userId = "poitt";
    String password = "passw";
    String nickname = "룰루랄";
    String username = "부우자";

    UserDto req = UserDto.builder()
            .userId(userId)
            .username(username)
            .password(password)
            .nickname(nickname)
            .build();

    userService.updateUser(id, req);

    User user = userService.getUserById(id);

    assertThat(user.getNickname()).isEqualTo(nickname);
    assertThat(user.getUsername()).isEqualTo(username);

    System.out.printf("User update Success");
  }




}
