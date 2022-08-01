package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService ;

    @Autowired
    public PersonController(PersonService personRepository) {
        this.personService = personRepository;
    }

    @GetMapping("/getPerson")
    public List<Person> getCompany(){
        return personService.getPerson();
    }
}
