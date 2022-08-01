package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;


    @Autowired
    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }
    public List<Jobs> Showjobs(){
        return jobsRepository.findAll() ;
    }
    public Jobs add(Jobs jobs){
        return jobsRepository.save(jobs);
    }

}
