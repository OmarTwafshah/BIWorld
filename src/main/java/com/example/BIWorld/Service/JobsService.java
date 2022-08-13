package com.example.BIWorld.Service;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;

import java.util.List;

public interface JobsService {
    Jobs add(Company companyID,
             String jobDescription,
             String jobField,
             String jobStartDate,
             String jobEndDate,
             Boolean jobIsFinished,
             String degreeRequierd,
             String genderToJob,
             String jobTime);

    void UpdateJob(int JobId,
                   Company companyID,
                   String jobDescription,
                   String jobField,
                   String jobStartDate,
                   String jobEndDate,
                   Boolean jobIsFinished,
                   String degreeRequierd,
                   String genderToJob,
                   String jobTime);

    Boolean deleteJob(int id);

    List<Jobs> SearchJob(Jobs job);

    List<Jobs> Showjobs();
}
