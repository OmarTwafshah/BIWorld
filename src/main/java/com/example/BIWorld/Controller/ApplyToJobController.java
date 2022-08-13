package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.ApplyToJobService;
import com.example.BIWorld.Service.ApplyToJobServiceImp;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ApplyToJobController {
    public final ApplyToJobService applyToJobService;

    public ApplyToJobController(ApplyToJobServiceImp applyToJobService) {
        this.applyToJobService = applyToJobService;
    }

    @PostMapping("/applyToJob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+5:30")

    public String ApplyToJob(@RequestParam(required = false) Set<Person> persons,
                             @RequestParam(required = false) Jobs jobs_To_application,
                             @RequestParam(required = false) String status) {

        ApplyToJob reapply = applyToJobService.addJobs(
                persons,
                jobs_To_application.getCompanyID(),
                jobs_To_application,
                status);
        if (reapply != null) {
            System.out.println("Doneeeeeeeeee");
        }
        return reapply == null ? "error" : "done";
    }

    @DeleteMapping("/deleteApp")
    public boolean deleteApp(@RequestParam(required = true) int AppId) {
        return applyToJobService.DeleteApp(AppId);
    }

    @GetMapping("/getApply")
    public List<ApplyToJob> getApplyJobs() {
        return applyToJobService.getApplyJobs();
    }


}
