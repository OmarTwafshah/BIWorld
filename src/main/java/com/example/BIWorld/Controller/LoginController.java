package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.Service.CompanyServiceImp;
import com.example.BIWorld.Service.PersonService;
import com.example.BIWorld.Service.PersonServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.LoginRequest;
import com.example.BIWorld.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private final CompanyService companyService;
    private final PersonService personService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public static String type = null;


    public LoginController(CompanyServiceImp companyService, PersonServiceImp personService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.companyService = companyService;
        this.personService = personService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.toString());
        Person person = personService.authenticatePerson(loginRequest.getUserName(), loginRequest.getMyPassword());
        if (person != null) {
            type = "person";
            return person;
        }
        Company company = companyService.authenticateCompany(loginRequest.getUserName(), loginRequest.getMyPassword());
        if (company != null) {
            type = "company";
            return company;
        }
        if (person == null && company == null) {
            return 1;
        }
        return null;

    }

//    @PostMapping("/login")
//    public Object login(@RequestBody LoginRequest loginRequest) throws Exception{
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getMyPassword())
//            );
//        } catch (Exception e) {
//            return null ;
//        }
//        return jwtUtil.generateToken(loginRequest.getUserName());
//    }

    @GetMapping("/test")
    public void testappp() {
        if (type != null) {
            System.out.println(type);
        } else {
            System.out.println("NOT LOGIN");
        }
    }
}
