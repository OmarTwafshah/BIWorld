package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.Service.JobsServiceImp;
import com.example.BIWorld.models.Jobs;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Job")
public class JobsController {
    private final JobsService jobsService;

    public JobsController(JobsServiceImp jobsService) {
        this.jobsService = jobsService;
    }


    @GetMapping("/Show")
    public List<Jobs> Showjobs() {
        System.out.println(LoginController.type);
        if (LoginController.type == null) {
            return null;
        }
        return jobsService.Showjobs();
    }

    @PostMapping("/add")
    public void jobs(@RequestBody JobsDTO jobsDTO) {
        if (LoginController.type == "company") {
            System.out.println(jobsDTO.toString());
            jobsService.add(jobsDTO);
        } else {
            System.out.println("Can Not Do It ");
            return;
        }


    }

    @PutMapping("/updatejob")
    public void UpdateJob(JobsDTO jobsDTO) {
        jobsService.UpdateJob(jobsDTO);
    }

    @DeleteMapping(path = "/deleteJob")
    public Boolean deleteStudent(@RequestParam(required = true) int id) {
        return jobsService.deleteJob(id);
    }

//    @GetMapping("/searchByFiled")
//    public List<Jobs> findByFiled(String filed) {
//        return jobsService.getJobsByFiled(filed);
//    }
//
//    @GetMapping("/searchByGender")
//    public List<Jobs> getJobByGender(String Gender) {
//        return jobsService.getJobByGender(Gender);
//    }
//
//    @GetMapping("/searchByDegree")
//    public List<Jobs> getJobByDegree(String Degree) {
//        return jobsService.getJobByDegree(Degree);
//    }
//
//    @GetMapping("/searchByTime")
//    public List<Jobs> getJobByTime(String Time) {
//        return jobsService.getJobByTime(Time);
//    }
//
//    @GetMapping("/searchByCompany")
//    public List<Jobs> getJobByCompany(Company CompanyID) {
//        return jobsService.getJobByCompany(CompanyID);
//    }

}
