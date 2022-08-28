package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.FilterJobs;
import com.example.BIWorld.requests.JobDetails;
import com.example.BIWorld.requests.Jobs_show;
import com.example.BIWorld.requests.SearchRequest;

import java.util.List;
import java.util.Map;

public interface JobsService {
    Object add(JobsDTO jobsDTO);

    void UpdateJob(JobsDTO jobsDTO);

    Boolean deleteJob(int id);

    List<Jobs> SearchJob(SearchRequest searchRequest);

    List<Jobs_show> Showjobs(FilterJobs filterJobs);

    Object getInfo(JobDetails jobDetails);
}
