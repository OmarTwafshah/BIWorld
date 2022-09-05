package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.ApplyToJobDTO;
import com.example.BIWorld.Service.ApplyToJobService;
import com.example.BIWorld.Service.ApplyToJobServiceImp;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.requests.UpdateStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applyToJob")
@CrossOrigin
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
        return "One Filed Is Empty";
    }

    @DeleteMapping("/deleteApp")
    public boolean deleteApp(@RequestParam(required = true) int AppId) {
        return applyToJobService.DeleteApp(AppId);
    }

    @GetMapping("/getApply")
    public List<ApplyToJob> getApplyJobs() {
        return applyToJobService.getApplyJobs();
    }

    @PutMapping("/update")
    public Object UpdateStatus(@RequestBody UpdateStatus updateStatus){
        return applyToJobService.UpdateStatus(updateStatus);
    }


}
