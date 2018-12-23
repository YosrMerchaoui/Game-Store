package com.example.demo.Repositories;

import com.example.demo.Models.Jouet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JouetRepository extends CrudRepository<Jouet,Integer>{
    public Jouet findById(int id);
}
