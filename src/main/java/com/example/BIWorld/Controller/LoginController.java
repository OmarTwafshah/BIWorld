package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.Service.CompanyServiceImp;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private final CompanyService companyService;
    private final PersonService personService;

    public static String type = null;


    public LoginController(CompanyServiceImp companyService, PersonServiceImp personService) {
        this.companyService = companyService;
        this.personService = personService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.toString());
        Company company = companyService.authenticateCompany(loginRequest.getUserName(), loginRequest.getMyPassword());
        if (company != null) {
            type = "company" ;
            return company;
        }
        Person person = personService.authenticatePerson(loginRequest.getUserName(), loginRequest.getMyPassword());
        if (person != null) {
            type = "person" ;
            return person;
        } else {
            return null;
        }

    }

    @GetMapping("/test")
    public void testappp() {
        if (type != null) {
            System.out.println(type);
        } else {
            System.out.println("NOT LOGIN");
        }
    }
}
