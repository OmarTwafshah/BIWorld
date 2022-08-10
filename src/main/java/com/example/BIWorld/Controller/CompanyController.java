package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    @PutMapping(path = "/updateCompany")
    public void updatecompany(int CompanyId,String companyName,
                              String companyUserName,
                              String companyPassword,
                              Set<City> cities,
                              String companyDescription,
                              Double CompanyPhone,
                              Long companyFax,
                              String companyEmail,
                              Integer companyTax,
                              String address){
        companyService.updatecompany(CompanyId, companyName,
                 companyUserName,
                 companyPassword,
                  cities,
                 companyDescription,
                 CompanyPhone,
                 companyFax,
                 companyEmail,
                 companyTax,
                 address);

    }
    @DeleteMapping(path = "/deleteCompany")
    public
    Boolean deleteStudent(@RequestParam(required = true) int id){
        return companyService.deleteJob(id);
    }

}
