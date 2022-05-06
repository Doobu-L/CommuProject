package com.ks.community.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/index")
public class IndexController {

  @RequestMapping("")
  public ModelAndView index(){
    ModelAndView view = new ModelAndView("view/login.html");
    return view;
  }
}
