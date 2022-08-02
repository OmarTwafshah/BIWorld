package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public List<Jobs> getJobsByFiled(String jobFiled){
       return jobsRepository.findByJobField(jobFiled);
    }
    public List<Jobs> getJobByGender(String Gender){
        return jobsRepository.findByGenderToJob(Gender);
    }
    public List<Jobs> getJobByDegree(String Degree){
        return  jobsRepository.findByDegreeRequierd(Degree);
    }
    public List<Jobs> getJobByTime(String Time){
        return jobsRepository.findByJobTime(Time);
    }
    public List<Jobs> getJobByCompany(Company CompanyId){
        return jobsRepository.findByCompanyID(CompanyId);
    }
    public Jobs add(Company companyID,
                    String jobDescription,
                    String jobField,
                    String jobStartDate,
                    String jobEndDate,
                    Boolean jobIsFinished,
                    String degreeRequierd,
                    String genderToJob,
                    String jobTime){

            if(
                    jobDescription==null || jobField==null || jobStartDate==null
                    || jobEndDate== null || jobIsFinished==null
                    || degreeRequierd==null || genderToJob==null|| jobTime==null){
                return null;

            }else{
                Jobs jobs=new Jobs();
                jobs.setCompanyID(companyID);
                jobs.setJobDescription(jobDescription);
                jobs.setJobField(jobField);
                jobs.setJobStartDate(LocalDate.parse(jobStartDate));
                jobs.setJobEndDate(LocalDate.parse(jobEndDate));
                jobs.setJobIsFinished(jobIsFinished);
                jobs.setDegreeRequierd(degreeRequierd);
                jobs.setGenderToJob(genderToJob);
                jobs.setJobTime(jobTime);
                return jobsRepository.save(jobs);
            }

    }

}
