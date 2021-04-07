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
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> addPerson(@RequestBody final Person person){
        return new ResponseEntity<PersonDTO>(personService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPerson(@RequestParam(value = "query", required = false) String query){
        if (query != null){
            return new ResponseEntity<List<PersonDTO>>( personService.getQueryPerson(query), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<PersonDTO>>( personService.getAllPerson(), HttpStatus.OK);
        }

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable final Long id){
        return new ResponseEntity<PersonDTO>(personService.getPerson(id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updatePerson(@RequestBody final Person person, @PathVariable final Long id){
        personService.updatePerson(person, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletePerson(@PathVariable final Long id){
        personService.deletePerson(id);
        return new ResponseEntity( HttpStatus.OK);
    }
}
