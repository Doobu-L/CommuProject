package com.ks.community.controller.v1;

import com.ks.community.dto.UserDto;
import com.ks.community.response.BaseResponse;
import com.ks.community.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Tag(name = "User", description = "회원관리 API")
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Operation(summary = "회원가입", description = "",
      responses = {
          @ApiResponse(responseCode = "200", description = "추가 성공", content = @Content(schema = @Schema(implementation = BaseResponse.class))),
          @ApiResponse(responseCode = "400", description = "추가 에러", content = @Content(schema = @Schema(implementation = BaseResponse.class)))
      })
  @PostMapping("/new")
  public ResponseEntity newUser(@RequestBody UserDto req){
    UserDto res =userService.newUser(req);
    return res != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
  }

}
