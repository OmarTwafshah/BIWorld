package com.example.BIWorld.Service;

import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;

import java.util.List;
import java.util.Set;

public interface ApplyToJobService {
    ApplyToJob addJobs(Set<Person> persons, Company company, Jobs jobs_to_application, String status);

    boolean DeleteApp(int appId);

    List<ApplyToJob> getApplyJobs();
}
