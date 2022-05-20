package com.ks.community.User;

import com.ks.community.domain.dto.UserDto;
import com.ks.community.domain.entity.User;
import com.ks.community.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
  
  @Autowired
  UserService userService;

  private UserDto userA(){
    return UserDto.builder()
        .userId("popo123")
        .username("테스트")
        .password("암호")
        .nickname("닉넴")
        .build();
  }

  private UserDto userB(){
    return UserDto.builder()
        .userId("dodo123")
        .username("테스트2")
        .password("암호2")
        .nickname("닉넴2")
        .build();
  }


  /**
   *  시나리오
   *  1. check 유저 -> false
   *  2. 닉네임 유효성검사 -> true
   *  3. insert
   * */
  @Test
  public void 유저_신규(){
    UserDto userA = userA();

    UserDto userDto = userService.newUser(userA);

    assertThat(userDto.getUserId()).isEqualTo(userA.getUserId());
    assertThat(userDto.getPassword()).isEqualTo(userA.getPassword());
    assertThat(userDto.getNickname()).isEqualTo(userA.getNickname());
    assertThat(userDto.getUsername()).isEqualTo(userA.getUsername());

    System.out.printf("User insert Success");
  }

  /**
   * 시나리오
   * 1. check 유저 -> true
   * 2. 수정을 원하는 요청값 유효성검사(nickname validation)
   * 3. update
   * */
  @Test
  public void 유저_수정(){
    long id = 3L;
    UserDto userB = userB();

    try {
      userService.updateUser(id, userB);
    }catch (Exception e){
      System.out.printf("유저 업데이트중 에러 발생");
      e.printStackTrace();
    }


    User user = userService.getUserById(id);

    assertThat(user.getNickname()).isEqualTo(userB.getNickname());

    System.out.printf("User update Success");
  }





}
