package com.ayhanekin.FirstSpringBoot.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public Laptop() {
    }

    @Override
    public void compile() {
        System.out.println("Compiling with Laptop");
    }
}
