/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.Reto4.repository;

import com.cuatroa.Reto4.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.Reto4.repository.Interface.ProductInterface;

/**
 *
 * @author Jose Diomedes Lopez
 * @version 1.0 12/12/2021
 */
@Repository
public class ProductRepository {
    
    @Autowired
    private ProductInterface supplementsInterface;

    public List<Product> getAll() {
        return supplementsInterface.findAll();
    }

    public Optional<Product> getSupplement(String reference) {
        return supplementsInterface.findById(reference);
    }
    public Product create(Product supplements) {
        return supplementsInterface.save(supplements);
    }

    public void update(Product supplements) {
        supplementsInterface.save(supplements);
    }
    
    public void delete(Product supplements) {
        supplementsInterface.delete(supplements);
    }
    
}
