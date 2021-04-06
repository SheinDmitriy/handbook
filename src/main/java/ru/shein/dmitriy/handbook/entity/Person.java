package ru.shein.dmitriy.handbook.entity;

import lombok.Data;
import ru.shein.dmitriy.handbook.dto.PersonDTO;

@Data
public class Person {

    public Person(String title, String phone, String address) {
        this.title = title;
        this.phone = phone;
        this.address = address;
    }

    public Person() {
    }

    private String title;

    private String phone;

    private String address;

    public static Person from(PersonDTO personDTO){
        Person person = new Person();
        person.setPhone(personDTO.getPhone());
        person.setAddress(personDTO.getAddress());
        person.setTitle(personDTO.getTitle());
        return person;
    }
}
