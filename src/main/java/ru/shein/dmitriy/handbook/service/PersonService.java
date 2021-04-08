package ru.shein.dmitriy.handbook.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shein.dmitriy.handbook.entity.Person;
import ru.shein.dmitriy.handbook.dto.PersonDTO;
import ru.shein.dmitriy.handbook.repositories.PersonRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

        personRepositories.delete(id);
    }

    public void updatePerson(Person person, Long id){
        personRepositories.setPerson(person, id);
    }

    public List<PersonDTO> getQueryPerson(String query) {
        List<PersonDTO> personDTO = new ArrayList<>();

        if (Pattern.matches("[a-zA-Z]+", query)) {
            for (PersonDTO pdto : personRepositories.getAllPerson()) {
               if ( pdto.getTitle().toLowerCase().startsWith(query.toLowerCase())){
                   personDTO.add(pdto);
               }
            }
        } else {
            for (PersonDTO pdto : personRepositories.getAllPerson()) {
                if ( pdto.getPhone().endsWith(query)){
                    personDTO.add(pdto);
                }
            }
        }
        return personDTO;
    }
}
