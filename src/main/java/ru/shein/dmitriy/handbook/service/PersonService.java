package ru.shein.dmitriy.handbook.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shein.dmitriy.handbook.repositories.PersonRepositories;

@Service
@Data
public class PersonService {

    private PersonRepositories personRepositories;

    @Autowired
    public PersonService(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }
}
