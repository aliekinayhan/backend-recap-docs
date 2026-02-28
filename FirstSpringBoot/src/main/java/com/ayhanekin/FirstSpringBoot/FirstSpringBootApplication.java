package com.ayhanekin.FirstSpringBoot;

import com.ayhanekin.FirstSpringBoot.model.Alien;
import com.ayhanekin.FirstSpringBoot.model.Laptop;
import com.ayhanekin.FirstSpringBoot.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FirstSpringBootApplication.class, args);

        Alien alien = context.getBean(Alien.class);
        Laptop laptop = context.getBean(Laptop.class);
        LaptopService service = context.getBean(LaptopService.class);
        service.addLaptop(laptop);
        alien.code();
        System.out.println(alien.getAge());


    }

}

// We avoid creating objects manually because it creates tight coupling.
// Instead, we declare classes as components and let the IoC container (ApplicationContext)
// create and inject them automatically, so we can focus only on business logic.

		/*
		Customer customer = new Customer();
		customer.print();
		in this project this line won't work because we used java not spring and the address
		didn't initialize in  customer class according to java, but spring boot does see what
		happens because  of annotations  so java don't see the application context

		Customer customer2 = context.getBean(Customer.class);

		System.out.println("*****************************");
		customer2.print();
		System.out.println("*****************************");
		*/