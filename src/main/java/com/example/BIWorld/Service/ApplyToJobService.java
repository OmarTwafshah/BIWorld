package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.ApplyToJobDTO;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.UpdateStatus;

import java.util.List;
import java.util.Set;

public interface ApplyToJobService {
    ApplyToJob addJobs(ApplyToJobDTO applyToJobDTO);

    boolean DeleteApp(int appId);

    List<ApplyToJob> getApplyJobs();

    boolean UpdateStatus(UpdateStatus updateStatus);
}
