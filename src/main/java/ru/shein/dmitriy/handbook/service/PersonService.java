package ru.shein.dmitriy.handbook.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shein.dmitriy.handbook.entity.Person;
import ru.shein.dmitriy.handbook.dto.PersonDTO;
import ru.shein.dmitriy.handbook.repositories.PersonRepositories;

import java.util.List;

@Service
@Data
public class PersonService {

    private PersonRepositories personRepositories;

    @Autowired
    public PersonService(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    public PersonDTO addPerson(Person person){
         return personRepositories.addPerson(person);
    }

    public List<PersonDTO> getAllPerson(){

        return personRepositories.getAllPerson();
    }

    public PersonDTO getPerson(Long id){
        return personRepositories.getPerson(id);
    }

    public void deletePerson(Long id){
        PersonDTO person = getPerson(id);
        personRepositories.delete(id);
    }

    public void updatePerson(Person person, Long id){
        personRepositories.setPerson(person, id);
    }
}
