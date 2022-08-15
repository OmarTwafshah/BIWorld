package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.Service.CompanyServiceImp;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final CompanyService companyService;
    private final PersonService personService;


    public static Company companyAll;

    public static Person personAll;

    public static String type = null;


    public LoginController(CompanyServiceImp companyService, PersonServiceImp personService) {
        this.companyService = companyService;
        this.personService = personService;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String Password) {
        System.out.println("The userName is : " + userName);
        System.out.println("The Password is : " + Password);
        Company company = companyService.authenticateCompany(userName, Password);
        if (company != null) {
            System.out.println("Company");
            companyAll = company;
            System.out.println("The Company Login");
            type = "company";
            return "Company";
        }
        Person person = personService.authenticatePerson(userName, Password);
        if (person != null) {
            System.out.println("Person");
            personAll = person;
            type = "person";
            System.out.println(personAll.getDateOfBirth());
            System.out.println("The Person Login");
            return "Person";
        } else {
            System.out.println("null");
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
