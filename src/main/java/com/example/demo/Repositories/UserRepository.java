package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
   public User findByMailAndPassword(String mail, String password);
}
