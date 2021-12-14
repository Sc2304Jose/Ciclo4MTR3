/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.Reto4.repository;

import com.cuatroa.Reto4.model.User;
import com.cuatroa.Reto4.repository.Interface.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeremy
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface userInterface;
    
    public List<User> getAll(){
        return userInterface.findAll();
    }
    
    public Optional<User> getUser(Integer id){
        return userInterface.findById(id);
    }
    
    public boolean ExisteEmail(String email){
        Optional<User> usuario = userInterface.findByEmail(email);
         
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUser(String email, String password){
        return userInterface.findByEmailAndPassword(email, password);
    }
    
    public User save(User user){
        return userInterface.save(user);
    }
    
    public void update(User user){
        userInterface.save(user);
    }
    
    public void delete(User user){
        userInterface.delete(user);
    }
    
}
