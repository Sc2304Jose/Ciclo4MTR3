/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.Reto4.controller;

import com.cuatroa.Reto4.model.Product;
import com.cuatroa.Reto4.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Jeremy
 */
@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService supplementsService;
       
    @GetMapping("/all")
    public List<Product> getAll() {
        return supplementsService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Product> getSupplement(@PathVariable("reference") String reference) {
        return supplementsService.getSupplement(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product supplements) {
        return supplementsService.save(supplements);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product supplements) {
        return supplementsService.update(supplements);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String supplements) {
        return supplementsService.delete(supplements);
    }
   
}
