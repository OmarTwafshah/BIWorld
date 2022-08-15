package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;

import java.util.List;

public interface JobsService {
    Jobs add(JobsDTO jobsDTO);

    void UpdateJob(JobsDTO jobsDTO);

    Boolean deleteJob(int id);

    List<Jobs> SearchJob(Jobs job);

    List<Jobs> Showjobs();
}
