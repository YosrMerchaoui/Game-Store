package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/login")
    public String login(Model model)
    {
        User user= new User();
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping(value="/LoginForm", method = RequestMethod.POST)
    public String postLogin(@ModelAttribute("user") User user, HttpSession session)
    {
        User user2 = userRepository.findByMailAndPassword(user.getMail(),user.getPassword());
      if (user2!=null) {
          session.setAttribute("user",user2);
          return "redirect:/";
      }
      else
      {
          return"redirect:/login";
      }


    }
}
