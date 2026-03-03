package com.ayhanekin.FirstSpringBoot.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
    String place = "Yeni mahalle su deposu A küme evleri no 13 ";

    void printIt () {
        System.out.println(place);
    }
}
