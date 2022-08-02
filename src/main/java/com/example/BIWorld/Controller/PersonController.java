package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/registerPerson")
    public String register(@ModelAttribute Person person){
        System.out.println("register Requiest" +person);
        Person rePerson = personService.registerPerson(person.getFullName(),
                person.getUserName(),
                person.getCity(),
                person.getPersonEmail(),
                person.getPassword(),
                person.getPersonPhone(),
                person.getPersonField(),
                person.getDateOfBirth(),
                person.getGender(),
                person.getStudyDegree(),
                person.getDescription(),
                person.getPicPath(),
                person.isHaveCV());
        if(rePerson != null){
            System.out.println("Doneeeeeeeeee");
        }
        return rePerson == null ? "error":"done";
    }
}
