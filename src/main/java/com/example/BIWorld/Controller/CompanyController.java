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
        System.out.println(companyDTO.toString());
        Company reCompany = (Company) companyService.registerCompany(companyDTO);
        if (reCompany.getCompanyName() != null) {
            return true;
        }
        return false;
    }

    @PutMapping(path = "/update")
    public void updatecompany(@RequestBody CompanyDTO companyDTO) {
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
