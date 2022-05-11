package com.ks.community.controller;

import com.ks.community.entity.User;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model){
    User user = (User) httpSession.getAttribute("user");

    if(user!=null)
      model.addAttribute("userName",user.getUsername());

    return "view/login.html";
  }


  @RequestMapping("/index")
  public ModelAndView index(){
    ModelAndView view = new ModelAndView("view/login.html");
    return view;
  }
}
