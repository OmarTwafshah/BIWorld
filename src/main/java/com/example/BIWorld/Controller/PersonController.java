package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Person")
@CrossOrigin
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonServiceImp personRepository) {
        this.personService = personRepository;
    }

    @GetMapping("/alldata")
    public List<Person> getCompany() {
        return personService.getPerson();
    }

    @PostMapping("/register")
    public Object register(@RequestBody PersonDTO personDTO, @RequestParam("image") MultipartFile multipartFile) {
        System.out.println(personDTO.toString());
        Person rePerson = null;
        try {
            rePerson = (Person) personService.registerPerson(personDTO, multipartFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (rePerson != null) {
            return true;
        }
        return false;
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody PersonDTO personDTO) {
        System.out.println(personDTO.getDateOfBirth().toString());
        System.out.println(personDTO.toString());
        personService.updatePerson(personDTO);

    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteStudent(@RequestParam(required = true) int id) {
        return personService.deletePerson(id);
    }

//    @DeleteMapping(path = "/delete/{id}")
//    public Boolean deleteStudent(@PathVariable int id) {
//        return personService.deletePerson(id);
//    }

    @GetMapping("/{id}/myApplication")
    public List<ApplicationPerson> showjob(@PathVariable int id) {
        return personService.ShowApplication(id);
    }
}
