package ru.shein.dmitriy.handbook.repositories;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.shein.dmitriy.handbook.entity.Person;
import ru.shein.dmitriy.handbook.dto.PersonDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@Data
public class PersonRepositories {

    @Value("${limit}")
    private int limit;

    private static LinkedHashMap<Long, Person> personList;

    @Autowired
    public PersonRepositories() {
        personList = new LinkedHashMap<>();

        Person person1 = new Person("Dima", "+1111111", "Perm");
        Person person2 = new Person("Sasha", "+2222222", "Perm");
        Person person3 = new Person("Marika", "+333333", "Ekaterinburg");

        personList.put(1L, person1);
        personList.put(2L, person2);
        personList.put(3L, person3);
    }

    public static Person getPerson(Long id){
        return personList.get(id);
    }

    public List<PersonDTO> getAllPerson(){
        List<PersonDTO> persons = new ArrayList<PersonDTO>();
        int count = 0;

        for (Map.Entry<Long, Person> pl : personList.entrySet()) {
            PersonDTO personDTO = PersonDTO.from(pl.getValue());
            personDTO.setId(pl.getKey());
            persons.add(personDTO);
            count++;
            if (count == limit)
                break;
        }
        return persons;
    }

    public PersonDTO addPerson(Person person){
        Long key = getLastKey() + 1L;
        personList.put(key, person);
        PersonDTO personDTO = PersonDTO.from(person);
        personDTO.setId(key);
        return personDTO;
    }

    public void setPerson(Person person, Long id){
        personList.put(id, person);
    }

    public void delete(Long id){
        personList.remove(id);
    }

    private Long getLastKey(){
        int count = 1;

        if(personList.size() == 0){
            return 0L;
        }

        for (Map.Entry<Long, Person> pl : personList.entrySet()) {

            if (count == personList.size()) {
                return pl.getKey();
            }
            count++;
        }
        return null;
    }
}
