package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.ApplyToJobService;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
public class ApplyToJobController {
    public final ApplyToJobService applyToJobService;
   @Autowired
    public ApplyToJobController(ApplyToJobService applyToJobService) {
        this.applyToJobService = applyToJobService;
    }
    @PostMapping("/addApply")
    public void ApplyToJob( Set<Person> persons,
                            Company company,
                            Jobs jobs_To_application,
                            String date_of_application,
                            String status){
       applyToJobService.ApplyJob(  persons,
                company,
                jobs_To_application,
                date_of_application,
                status);
    }
    @DeleteMapping("/deleteApp")
    public boolean deleteApp(@RequestParam(required = true) int AppId){
       return applyToJobService.DeleteApp(AppId);
    }
}
