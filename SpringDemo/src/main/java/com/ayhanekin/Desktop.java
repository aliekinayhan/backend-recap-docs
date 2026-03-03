package com.ayhanekin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Desktop implements Computer{

    public Desktop() {
        System.out.println("Desktop Object has Created...");
    }

    @Override
    public void compile() {
        System.out.println("Compiling with Desktop...");
    }
}
