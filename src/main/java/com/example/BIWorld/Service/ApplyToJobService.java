package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.ApplyToJobDTO;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.requests.UpdateStatus;
import java.util.List;

public interface ApplyToJobService {
    ApplyToJob addJobs(ApplyToJobDTO applyToJobDTO);

    boolean DeleteApp(int appId);

    List<ApplyToJob> getApplyJobs();

    Object UpdateStatus(UpdateStatus updateStatus);
}
