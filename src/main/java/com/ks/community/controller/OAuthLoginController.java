package com.ks.community.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class OAuthLoginController {

  @GetMapping("/oauth")
  public String googleLogin(HttpServletRequest req, HttpServletResponse res){
    System.out.printf("GGGGGGG : "+ req.getParameter("code"));
    return "";
  }
}
