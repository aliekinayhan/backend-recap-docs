package com.ayhanekin.FirstSpringBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Customer {

    @Value("13")
    private int block;
    private Address address;

    public Customer() {

    }

    void print() {
        address.printIt();
        System.out.println("Hello World This is the Address");
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
