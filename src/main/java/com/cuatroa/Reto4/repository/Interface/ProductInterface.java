/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.Reto4.repository.Interface;

import com.cuatroa.Reto4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Jeremy
 */
public interface ProductInterface extends MongoRepository<Product, String> {
    
}
