package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.ApplyToJobDTO;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ApplyToJobServiceImp implements ApplyToJobService {
    public final applyToJobRepository applyToJobRepository;
    public final JobsRepository jobsRepository;

    public final PersonRepository personRepository;

    public ApplyToJobServiceImp(com.example.BIWorld.Repository.applyToJobRepository applyToJobRepository, JobsRepository jobsRepository, PersonRepository personRepository) {
        this.applyToJobRepository = applyToJobRepository;
        this.jobsRepository = jobsRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ApplyToJob addJobs(ApplyToJobDTO applyToJobDTO) {
        if (applyToJobDTO.getId()== null
                || applyToJobDTO.getJobID() == null) {
            return null;
        } else {
            ApplyToJob applyToJob = new ApplyToJob();
            Person person = personRepository.findByPerson_id(applyToJobDTO.getId());
            System.out.println(person.getFullName());
            applyToJob.setPersons(person);
            Jobs jobs = jobsRepository.findByJobId(applyToJobDTO.getJobID());
            System.out.println(jobs.toString());
            applyToJob.setCompany(jobs.getCompanyID());
            applyToJob.setJobs_To_application(jobs);
            LocalDate currentDateTime = LocalDate.from(LocalDate.now());
            applyToJob.setDate_of_application(currentDateTime);
            applyToJob.setStatus("");
            return applyToJobRepository.save(applyToJob);
        }


    }

    @Override
    public boolean DeleteApp(int appId) {
        Boolean exist = applyToJobRepository.existsById(appId);
        if (!exist) {
            System.out.println("job does not exist");
            return false;
        }
        applyToJobRepository.deleteById(appId);
        return true;
    }

    @Override
    public List<ApplyToJob> getApplyJobs() {
        return applyToJobRepository.findAll();
    }
}
