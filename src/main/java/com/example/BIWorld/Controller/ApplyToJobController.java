package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.ApplyToJobDTO;
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
@RequestMapping("/applyToJob")
public class ApplyToJobController {
    public final ApplyToJobService applyToJobService;

    public ApplyToJobController(ApplyToJobServiceImp applyToJobService) {
        this.applyToJobService = applyToJobService;
    }

    @PostMapping("/add")
    public Object ApplyToJob(@RequestBody ApplyToJobDTO applyToJobDTO) {
        ApplyToJob reapply = applyToJobService.addJobs(applyToJobDTO);
        if (reapply != null) {
            return true;
        }
        return false;
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
