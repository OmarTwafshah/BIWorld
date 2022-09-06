package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import com.example.BIWorld.requests.PersonProfile;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Object rePerson = null;
        try {
            rePerson = personService.registerPerson(personDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (rePerson == "One filed is empty") {
            return "One filed is empty";
        } else if (rePerson == "User Name is Used") {
            return "User Name is Used";
        } else if (rePerson == "Email is Used") {
            return "Email is Used";
        } else if (rePerson == "Phone Number is Used") {
            return "Phone Number is Used";
        } else if (rePerson == "Your Age Less That You Can Work") {
            return "Your Age Less That You Can Work";
        } else if (rePerson == "City Not Found") {
            return "City Not Found";
        } else {
            return true;
        }
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody PersonDTO personDTO) {
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
    public PersonProfile getJustPerson(@PathVariable int id) {
        return personService.getJustPerson(id);
    }

    @GetMapping("/{id}/getImage")
    public ResponseEntity<Resource> getimage(@PathVariable int id) throws Exception {
        return personService.getimage(id);
    }

    @GetMapping("/{id}/getCV")
    public ResponseEntity<Resource> getCV(@PathVariable int id) throws Exception {
        return personService.getCV(id);
    }
}
