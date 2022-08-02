package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobsController {
    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }


    @GetMapping("/home")
    public List<Jobs> Showjobs(){
        return jobsService.Showjobs();
    }
    @PostMapping("/addjob")
    public void jobs(@ModelAttribute Jobs job){
      jobsService.add(job.getCompanyID(),
              job.getJobDescription(),
              job.getJobField(),
              String.valueOf(job.getJobStartDate()),
              String.valueOf(job.getJobEndDate()),
              job.getJobIsFinished(),
              job.getDegreeRequierd(),
              job.getGenderToJob(),
              job.getJobTime());

    }

    @GetMapping("/searchByFiled")
    public List<Jobs> findByFiled(String filed){
        return jobsService.getJobsByFiled(filed);
    }
    @GetMapping("/searchByGender")
    public List<Jobs> getJobByGender(String Gender){
        return jobsService.getJobByGender(Gender);
    }
    @GetMapping("/searchByDegree")
    public List<Jobs> getJobByDegree(String Degree){
        return jobsService.getJobByDegree(Degree);
    }
    @GetMapping("/searchByTime")
    public List<Jobs> getJobByTime(String Time){
        return jobsService.getJobByTime(Time);
    }
    @GetMapping("/searchByCompany")
    public List<Jobs> getJobByCompany(Company CompanyID){
        return jobsService.getJobByCompany(CompanyID);
    }

}
