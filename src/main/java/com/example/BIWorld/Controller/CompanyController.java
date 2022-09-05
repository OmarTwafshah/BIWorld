package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.CompanyDTO;
import com.example.BIWorld.Service.CompanyService;
import com.example.BIWorld.Service.CompanyServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Company")
@CrossOrigin
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyServiceImp companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/alldata")
    public List<Company> getCompany() {
        return companyService.getCompany();
    }

    @PostMapping("/register")
    public Object register(@RequestBody CompanyDTO companyDTO) {
        Object reCompany =  companyService.registerCompany(companyDTO);
        if(reCompany == "One filed is empty"){
            return "One filed is empty";
        }else if(reCompany == "User Name is Used"){
            return "User Name is Used" ;
        }else if(reCompany == "Email is Used"){
            return "Email is Used" ;
        }else if(reCompany == "Fax number is Used"){
            return "Fax number is Used" ;
        }else if(reCompany == "Tax number is Used"){
            return "Tax number is Used" ;
        }else if(reCompany == "Phone Number is Used"){
            return "Phone Number is Used" ;
        }else {
            return true;
        }
    }

    @PutMapping(path = "/update")
    public void updatecompany(@RequestBody CompanyDTO companyDTO) {
        System.out.println(companyDTO.toString());
        companyService.updatecompany(companyDTO);

    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteStudent(@RequestParam(required = true) int id) {
        return companyService.deleteJob(id);
    }

    @GetMapping("/{id}/showJobs")
    public Set<Jobs> findJobsByCompany(@PathVariable int id) {
        return companyService.getJobs(id);
    }

//    @GetMapping("/jobInfo")
//    public Object getAlljobs()

}
