package ru.shein.dmitriy.handbook.entity;

import lombok.Data;

@Data
public class Person {

    public Person(String title, String phone, String address) {
        this.title = title;
        this.phone = phone;
        this.address = address;
    }

    private String title;

    private String phone;

    private String address;
}
