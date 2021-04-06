package ru.shein.dmitriy.handbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shein.dmitriy.handbook.dto.PersonDTO;
import ru.shein.dmitriy.handbook.entity.Person;
import ru.shein.dmitriy.handbook.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/person")
    public ResponseEntity<PersonDTO> addPerson(@RequestBody final Person person){
//        personService.addPerson(person);
        return new ResponseEntity<PersonDTO>(personService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping(value = "/person")
    public ResponseEntity<List<PersonDTO>> getAllPerson(){
        return new ResponseEntity<List<PersonDTO>>( personService.getAllPerson(), HttpStatus.OK);
    }

}
