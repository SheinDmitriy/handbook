package ru.shein.dmitriy.handbook.entityDTO;

import lombok.Data;

@Data
public class PersonDTO {

    public PersonDTO(Long id, String title, String phone, String address) {
        this.id = id;
        this.title = title;
        this.phone = phone;
        this.address = address;
    }

    private Long id;

    private String title;

    private String phone;

    private String address;
}
