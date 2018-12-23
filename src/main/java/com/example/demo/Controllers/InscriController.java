package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class InscriController {
    @Autowired
     UserRepository userRepository;

    @RequestMapping(value="/inscri")
    public String preFormInscri(Model model)
    {
        User user= new User();
        model.addAttribute("user",user);
        return"inscription";
    }

    @RequestMapping(value = "/inscriForm", method= RequestMethod.POST)
    public String postFormInscri(@ModelAttribute("user") User user, HttpSession session){
        session.setAttribute("user",user);
        userRepository.save(user);
        return "redirect:/";

    }

}
