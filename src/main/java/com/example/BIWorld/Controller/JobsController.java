package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.models.Jobs;
import org.springframework.web.bind.annotation.GetMapping;
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
    public void jobs(Jobs job){
       jobsService.add(job);
    }
}
