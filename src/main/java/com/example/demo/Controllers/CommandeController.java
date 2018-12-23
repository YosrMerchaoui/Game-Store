package com.example.demo.Controllers;

import com.example.demo.Models.Commande;

import com.example.demo.Models.Jouet;
import com.example.demo.Models.User;
import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.JouetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    JouetRepository jouetRepository;



    @RequestMapping("/commande")
    public String commandes(HttpSession session, Model model3,Model model4){
        Commande commande=(Commande) session.getAttribute("commande");
        List<Jouet> cmdJouets=commande.getJouets();

        model3.addAttribute("cmdJouets",cmdJouets);
        model4.addAttribute("commande",commande);

        return "mesCommandes";
    }

    @RequestMapping(value = "/AjoutPanier/{id}", method = RequestMethod.GET)
    public  String ajoutPanier(HttpSession session, @PathVariable("id") int idJouet){
        Jouet jouet = jouetRepository.findOne(idJouet);
        Commande commande=(Commande) session.getAttribute("commande");

        if (commande == null){


            ArrayList<Jouet> listJouet = new ArrayList<Jouet>();
            listJouet.add(jouet);
            double prixtotal=0;
            for (Jouet jouuet:listJouet) {
                prixtotal+=jouuet.getPrix();
            }
            commande = new Commande(null,prixtotal,(User)session.getAttribute("user"),listJouet);
            session.setAttribute("commande",commande);
            System.out.println("commande nulle");
            System.out.println(commande.getId());
            System.out.println(commande.getDate());
            System.out.println(commande.getPrixTotal());
            System.out.println(commande.getUser().getNom());
            System.out.println(commande.getJouets().get(0).getNom());


            commandeRepository.save(commande);

        }

        else {
            System.out.println("commande non nulle");
            List<Jouet> listJouet = commande.getJouets();
            listJouet.add(jouet);
            commande.setPrixTotal(commande.getPrixTotal()+jouet.getPrix());
            commande.setJouets(listJouet);

            System.out.println(commande.getId());
            System.out.println(commande.getDate());
            System.out.println(commande.getPrixTotal());
            System.out.println(commande.getUser().getNom());
            System.out.println(commande.getJouets().get(0).getNom());
            System.out.println(commande.getJouets().get(0).getId());
            System.out.println(commande.getJouets().get(1).getNom());
            System.out.println(commande.getJouets().get(1).getId());
            commandeRepository.save(commande);

        }

        return "redirect:/";
    }


    @RequestMapping(value = "/annulation" ,method = RequestMethod.GET)
    public String annuler(HttpSession session){

        session.removeAttribute("commande");
        return "redirect:/";

    }

    @RequestMapping(value = "/supprimJouet/{id}",method = RequestMethod.GET)
    public String supprim(HttpSession session,@PathVariable("id") int idJouuet){
        Commande commande=(Commande) session.getAttribute("commande");

        List<Jouet> listJouets1=commande.getJouets();

        ArrayList<Jouet> listJouets=new ArrayList<Jouet>();

        for (Jouet jouuet1:listJouets1) {
            listJouets.add(jouuet1);
        }


        for (Jouet jouuet : listJouets)
        {
                if (jouuet.getId() == idJouuet) {
                    listJouets.remove(jouuet);
                }
                if(listJouets.size()==0)
                    break;
        }


        commande.setJouets(listJouets);


        if(commande.getJouets().size()==0)
        {
            return "redirect:/annulation";
        }
         return "redirect:/commande";
        }
    }





