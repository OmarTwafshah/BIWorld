package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.Service.JobsServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.FilterJobs;
import com.example.BIWorld.requests.JobDetails;
import com.example.BIWorld.requests.Jobs_show;
import com.example.BIWorld.requests.SearchRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Job")
public class JobsController {
    private final JobsService jobsService;

    private final CompanyRepository companyRepository;

    private final PersonRepository personRepository;

    public JobsController(JobsServiceImp jobsService, CompanyRepository companyRepository, PersonRepository personRepository) {
        this.jobsService = jobsService;
        this.companyRepository = companyRepository;
        this.personRepository = personRepository;
    }


    @GetMapping("/Show")
    public List<Jobs_show> Showjobs(@ModelAttribute FilterJobs filterJobs) {
        System.out.println(filterJobs.toString());
        Person person = personRepository.findByPerson_id(filterJobs.getPersonID());
        if (person != null) {
            return jobsService.Showjobs(filterJobs);
        }
        return null;

    }

    @PostMapping("/add")
    public Boolean jobs(@RequestBody JobsDTO jobsDTO) {
        Company company = companyRepository.findByCompany_id(jobsDTO.getCompanyID());
        if (company != null) {
            jobsService.add(jobsDTO);
            return true;
        } else {
            return false;
        }

    }

    @PutMapping("/update")
    public void UpdateJob(@RequestBody JobsDTO jobsDTO) {
        jobsService.UpdateJob(jobsDTO);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteStudent(@RequestParam(required = true) int id) {
        return jobsService.deleteJob(id);
    }

    @GetMapping("/search")
    public List<Jobs> SearchJob(@ModelAttribute SearchRequest searchRequest) {
        Map<JobsServiceImp.Search, Object> fields = new HashMap<>();
        if (searchRequest.getGender() != null) {
            fields.put(JobsServiceImp.Search.GENDER, searchRequest.getGender());
        }
        if (searchRequest.getCity() != null) {
            fields.put(JobsServiceImp.Search.CITY, searchRequest.getCity());
        }
        if (searchRequest.getPersonField() != null) {
            fields.put(JobsServiceImp.Search.FILED, searchRequest.getPersonField());
        }
        if (searchRequest.getStudyDegree() != null) {
            fields.put(JobsServiceImp.Search.STUDYDEGREE, searchRequest.getStudyDegree());
        }

        return jobsService.SearchJob(searchRequest);
    }

    @GetMapping("/ShowDetails")
    public Object jobDetails(@ModelAttribute JobDetails jobDetails) {
        return jobsService.getInfo(jobDetails);
    }

}
