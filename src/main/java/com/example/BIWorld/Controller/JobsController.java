package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.Service.JobsServiceImp;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.FilterJobs;
import com.example.BIWorld.requests.SearchRequest;
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
    public List<Jobs> Showjobs(@ModelAttribute FilterJobs filterJobs) {
        if (LoginController.type != null) {
            System.out.println(filterJobs.toString());
            return jobsService.Showjobs(filterJobs);
        }
        return null;

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
        return jobsService.SearchJob(searchRequest);
    }

}
