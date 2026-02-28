package com.ayhanekin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Laptop implements Computer {
    public Laptop() {
        System.out.println("Laptop Object has Created...");
    }

    public void compile () {
        System.out.println("Compiling with Laptop...");
    }
}
