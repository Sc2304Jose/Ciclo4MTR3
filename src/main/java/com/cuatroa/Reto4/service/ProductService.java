/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.Reto4.service;

import com.cuatroa.Reto4.model.Product;
import com.cuatroa.Reto4.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeremy
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository supplementsRepository;

    public List<Product> getAll() {
        return supplementsRepository.getAll();
    }

   public Optional<Product> getSupplement(String reference) {
        return supplementsRepository.getSupplement(reference);
    }

    public Product save(Product accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return supplementsRepository.create(accesory);
        }
    }

    public Product update(Product accesory) {

        if (accesory.getReference() != null) {
            Optional<Product> accesoryDb = supplementsRepository.getSupplement(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                supplementsRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(accesory -> {
            supplementsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
