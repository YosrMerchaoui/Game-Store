package com.example.demo.Controllers;

import com.example.demo.Models.Commande;
import com.example.demo.Models.Jouet;
import com.example.demo.Models.User;
import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.JouetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JouetController {

    @Autowired
    JouetRepository jouetRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @RequestMapping(value="/preAjoutJouet")
    public String PreAjout(Model model)
    {
        Jouet jouet = new Jouet();
        model.addAttribute("jouet",jouet);
        return "ajoutJouet";
    }

    @RequestMapping(value = "/postAjoutJouet", method = RequestMethod.POST)
    public String postAjout (@ModelAttribute("jouet") Jouet jouet, @RequestParam("image") MultipartFile file, HttpSession session) {

        String rootDir = session.getServletContext().getRealPath("/");

        if (file.isEmpty())
             {
            jouet.setPhoto("images.jpg");

             }
             else
             {

                      try {
                              byte[] bytes = file.getBytes();
                              Path path = Paths.get(rootDir + "/../../../../src/main/resources/static/img/" + file.getOriginalFilename());

                              Files.write(path, bytes);
                              jouet.setPhoto(file.getOriginalFilename());
                          }
                     catch (IOException e)
                          {
                              jouet.setPhoto("images.jpg");
                          }
             }
        jouetRepository.save(jouet);
        return "redirect:/";
    }



    @RequestMapping(value = "/SuppJouet/{id}",method = RequestMethod.GET)
    public  String suppJouet(@PathVariable("id") int idJouet){
        Jouet jouet = jouetRepository.findOne(idJouet);
        jouetRepository.delete(jouet);
        return "redirect:/";
    }



    @RequestMapping(value = "/PreModifJouet/{id}",method = RequestMethod.GET)
    public  String preAjoutJouet(@PathVariable("id") int idJouet, Model model){
        Jouet jouet = jouetRepository.findOne(idJouet);
        model.addAttribute(jouet);
        return "modifJouet";
    }



    @RequestMapping(value = "/PostModifJouet",method = RequestMethod.POST)
    public  String postAjoutJouet(@ModelAttribute("jouet") Jouet jouet,@RequestParam("image") MultipartFile file, HttpSession session){

        String rootDir = session.getServletContext().getRealPath("/");

        if (file.isEmpty())
        {
            jouet.setPhoto("images.jpg");

        }
        else
        {

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(rootDir + "/../../../../src/main/resources/static/img/" + file.getOriginalFilename());
                Files.write(path, bytes);
                jouet.setPhoto(file.getOriginalFilename());
            }
            catch (IOException e)
            {
                jouet.setPhoto("images.jpg");
            }
        }
        jouetRepository.save(jouet);
        return "redirect:/";
    }






}
