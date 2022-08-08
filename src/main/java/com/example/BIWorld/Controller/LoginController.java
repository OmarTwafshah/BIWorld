package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final CompanyService companyService ;
    private final PersonService personService ;



    public static Company companyAll ;

    public static Person personAll;

    public static String type = null ;


    @Autowired
    public LoginController(CompanyService companyService, PersonService personService) {
        this.companyService = companyService;
        this.personService = personService;
    }

    @PostMapping("/login")
    public String login(String userName , String Password){
        System.out.println("The userNAme is : "+userName);
        System.out.println("The PAssword is : "+Password);
        Company company = companyService.authenticateCompany(userName,Password) ;
        Person person = personService.authenticatePerson(userName,Password);
        if(company!= null){
            System.out.println("Company");
            companyAll = company;
            System.out.println("The Company Login");
            type = "company";
            return "Company";
        }else if(person!=null){
            System.out.println("Person");
            personAll = person ;
            type = "person";
            System.out.println(personAll.getDateOfBirth());
            System.out.println("The Person Login");
            return "Person";
        }else {
            System.out.println("null");
            return null ;
        }

    }
}
