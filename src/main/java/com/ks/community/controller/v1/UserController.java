package com.ks.community.controller.v1;

import com.ks.community.dto.UserDto;
import com.ks.community.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "User", description = "회원관리 API")
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Operation(summary = "회원 가입", description = "")
  @PostMapping("/new")
  public ResponseEntity newUser(@RequestBody UserDto req){
    UserDto res =userService.newUser(req);
    return res != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
  }

  @Operation(summary = "id로 회원 조회", description = "")
  @PostMapping("/{id}")
  public ResponseEntity getUserById(@PathVariable long id){
    UserDto res =userService.getUserById(id);
    return ResponseEntity.ok().body(res);
  }

  @Operation(summary = "회원 수정", description = "")
  @PutMapping("/{id}")
  public ResponseEntity updateUser(@PathVariable long id,@RequestBody UserDto req) throws Exception{
    boolean res = userService.updateUser(id,req);
    return ResponseEntity.ok().body(res);
  }


}
