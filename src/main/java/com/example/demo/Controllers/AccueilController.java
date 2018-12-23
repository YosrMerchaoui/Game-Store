package com.example.demo.Controllers;


import com.example.demo.Models.Commande;
import com.example.demo.Models.Jouet;
import com.example.demo.Models.User;
import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.JouetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AccueilController {

    @Autowired
    JouetRepository jouetRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @RequestMapping("/")
    public String accueil(Model model,Model model2 ,Model model3,HttpSession session){
        User user =(User) session.getAttribute("user");
        Commande commande=(Commande) session.getAttribute("commande");

        model.addAttribute("user",user);

        List<Jouet> jouets = (List<Jouet>) jouetRepository.findAll();

        model2.addAttribute("jouets",jouets);
        model3.addAttribute("commande",commande);
        return "Accueil";}

    @RequestMapping("/accueilDeconnexion")
    public  String accueilDeco(HttpSession session){
        session.removeAttribute("user");
        Commande commande=(Commande)session.getAttribute("commande");
        if(commande != null)
            session.removeAttribute("commande");

        return "redirect:/";
    }

    @RequestMapping("/search")
    public String search(){


        return "redirect:/";
    }
}


