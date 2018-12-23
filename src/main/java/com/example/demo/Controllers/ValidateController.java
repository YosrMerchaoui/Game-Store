package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateController {


    @RequestMapping("/Validate")
    public String valider(){
        return "Fin";
    }

}
