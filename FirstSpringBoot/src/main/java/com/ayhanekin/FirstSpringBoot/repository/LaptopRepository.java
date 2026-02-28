package com.ayhanekin.FirstSpringBoot.repository;

import com.ayhanekin.FirstSpringBoot.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save (Laptop laptop) {
        System.out.println("Saved in Repository");
    }
}
