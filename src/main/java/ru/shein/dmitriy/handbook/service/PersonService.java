package ru.shein.dmitriy.handbook.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shein.dmitriy.handbook.entity.Person;
import ru.shein.dmitriy.handbook.entityDTO.PersonDTO;
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

    public void addPerson(Person person){
         personRepositories.addPerson(person);
    }

    public List<PersonDTO> getAllPerson(){


        return null;
    }

    public Person getPerson(Long id){
        return personRepositories.getPerson(id);
    }

    public void deletePerson(Long id){
        Person person = getPerson(id);
        personRepositories.delete(id);
    }

    public void updatePerson(PersonDTO personDTO){
        Person person = getPerson(personDTO.getId());
        personRepositories.setPerson(personDTO);
    }
}
