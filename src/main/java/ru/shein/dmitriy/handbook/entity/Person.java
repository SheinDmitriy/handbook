package ru.shein.dmitriy.handbook.entity;

import lombok.Data;

@Data
public class Person {
    private Long id;

    private String title;

    private String phone;

    private String address;
}
