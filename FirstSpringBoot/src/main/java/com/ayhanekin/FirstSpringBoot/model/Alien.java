package com.ayhanekin.FirstSpringBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("25")
    private int age;
    private Computer computer;

    public Alien() {
    }

    public void code() {
        System.out.println("Coding...");
        computer.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired
    @Qualifier("desktop")
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
