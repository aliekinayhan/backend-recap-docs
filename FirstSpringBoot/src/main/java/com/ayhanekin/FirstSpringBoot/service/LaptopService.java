package com.ayhanekin.FirstSpringBoot.service;

import com.ayhanekin.FirstSpringBoot.model.Laptop;
import com.ayhanekin.FirstSpringBoot.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository repository;

    public void addLaptop(Laptop laptop) {
        repository.save(laptop);
    }
}
