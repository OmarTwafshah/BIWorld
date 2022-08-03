package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService ;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getCompany")
    public List<Company> getCompany(){
        return companyService.getCompany();
    }

    @PostMapping("/registerCompany")
    public String register(@ModelAttribute Company company){
        System.out.println("register Requiest" +company);
        Company reCompany = companyService.registerCompany(
                company.getCompanyName(),
                company.getCompanyUserName(),
                company.getCompanyPassword(),
                company.getCities(),
                company.getCompanyDescription(),
                company.getCompanyPhone(),
                company.getCompanyFax(),
                company.getCompanyEmail(),
                company.getCompanyTax(),
                company.getAddress());
        if(reCompany != null){
            System.out.println("Doneeeeeeeeee");
        }
        return reCompany == null ? "error":"done";
    }

}
