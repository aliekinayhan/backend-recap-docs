package com.ayhanekin.FirstSpringBoot.model;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    public Desktop() {
    }

    @Override
    public void compile() {
        System.out.println("Compiling with Desktop");
    }
}
