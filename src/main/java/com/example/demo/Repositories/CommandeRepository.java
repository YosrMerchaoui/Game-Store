package com.example.demo.Repositories;

import com.example.demo.Models.Commande;
import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande,Integer> {
    public Commande findByUser(User user);
    public Commande findById(int id);
}
