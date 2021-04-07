package ru.shein.dmitriy.handbook.dto;

import lombok.Data;
import ru.shein.dmitriy.handbook.entity.Person;

@Data
public class PersonDTO {

    public PersonDTO(Long id, String title, String phone, String address) {
        this.id = id;
        this.title = title;
        this.phone = phone;
        this.address = address;
    }

    public PersonDTO() {
    }

    private Long id;

    private String title;

    private String phone;

    private String address;

    public static PersonDTO from(Person person){


        PersonDTO personDTO = new PersonDTO();
        personDTO.setAddress(person.getAddress());
        personDTO.setPhone(person.getPhone());
        personDTO.setTitle(person.getTitle());
        return personDTO;
    }
}
