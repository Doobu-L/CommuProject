package com.ks.community.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login/oauth")
@RestController
public class OAuthLoginController {

  @GetMapping("/google")
  public String googleLogin(HttpServletRequest req, HttpServletResponse res){
    System.out.printf("GGGGGGG : "+ req.getParameter("code"));
    return "";
  }
}
