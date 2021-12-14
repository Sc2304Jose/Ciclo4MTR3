package com.cuatroa.Reto4;

import com.cuatroa.Reto4.repository.Interface.OrderInterface;
import com.cuatroa.Reto4.repository.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.cuatroa.Reto4.repository.Interface.ProductInterface;

@Component
@SpringBootApplication
public class Reto4Application implements CommandLineRunner {

    @Autowired
    private OrderInterface orderInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private ProductInterface supplementsInterface;

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

	@Override
    public void run(String... args) throws Exception {
        supplementsInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
