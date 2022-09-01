package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @PostMapping(value = "/register", consumes = {"multipart/form-data"})
    public Object register(@ModelAttribute PersonDTO personDTO) {
        System.out.println(personDTO.toString());
        System.out.println(StringUtils.cleanPath(personDTO.getCvPath().getOriginalFilename()));
        System.out.println(StringUtils.cleanPath(personDTO.getPicPath().getOriginalFilename()));
        Object rePerson = null;
        try {
            rePerson = personService.registerPerson(personDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (rePerson != null) {
            return rePerson;
        }
        return null;
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

    @GetMapping("/{id}/getCand")
    public Person getJustPerson(@PathVariable int id) {
        return personService.getJustPerson(id);
    }

    @GetMapping("/{id}/getImage")
    public ResponseEntity<Resource> getimage(@PathVariable int id) throws Exception {
        return personService.getimage(id);
    }
}
