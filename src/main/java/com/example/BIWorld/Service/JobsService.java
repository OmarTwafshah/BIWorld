package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;


    @Autowired
    public JobsService(JobsRepository jobsRepository, CompanyRepository companyRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
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

                Jobs jobs1 = jobsRepository.save(jobs);
                Set<Jobs> jobs2 = new HashSet<>();
                jobs2.add(jobs1);
                companyID.setJobs(jobs2);
                return jobs ;

            }

    }
    @Transactional
    public void UpdateJob(int JobId,Company companyID,
                          String jobDescription,
                          String jobField,
                          String jobStartDate,
                          String jobEndDate,
                          Boolean jobIsFinished,
                          String degreeRequierd,
                          String genderToJob,
                          String jobTime){

        Jobs jobs=jobsRepository.findById(JobId).orElseThrow(() -> new IllegalStateException("id is not found"));
        if(companyID!= null){jobs.setCompanyID(companyID);}
        if(jobDescription!=null){jobs.setJobDescription(jobDescription);}
        if(jobField!=null){jobs.setJobField(jobField);}
        if(jobStartDate!=null){jobs.setJobStartDate(LocalDate.parse(jobStartDate));}
        if(jobEndDate!=null){jobs.setJobEndDate(LocalDate.parse(jobEndDate));}
        if(jobIsFinished!=null){jobs.setJobIsFinished(jobIsFinished);}
        if(degreeRequierd!=null){jobs.setDegreeRequierd(degreeRequierd);}
        if(genderToJob!=null){jobs.setGenderToJob(genderToJob);}
        if(jobTime!=null){jobs.setJobTime(jobTime);}




    }

}
