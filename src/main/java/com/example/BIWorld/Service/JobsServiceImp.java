package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobsServiceImp implements JobsService{
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;

    public static String select ;


    public JobsServiceImp(JobsRepository jobsRepository, CompanyRepository companyRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
    }

    @Override
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
    @Override
    public Jobs add(JobsDTO jobsDTO){

            if(
                    jobsDTO.getJobCompany() == null || jobsDTO.getJobDescription()==null || jobsDTO.getJobField()==null || jobsDTO.getJobStartDate()==null
                    || jobsDTO.getJobEndDate()== null || jobsDTO.getJobIsFinished()==null
                    || jobsDTO.getDegreeRequierd()==null || jobsDTO.getGenderToJob()==null|| jobsDTO.getJobTime()==null){
                return null;

            }else{
                Jobs jobs=new Jobs();
                if(companyRepository.findById(jobsDTO.getJobCompany().getCompany_id()).isEmpty()){
                    System.out.println(jobsDTO.getJobCompany().getCompany_id() +" is not found ");
                    return null;
                }else {
                    jobs.setCompanyID(jobsDTO.getJobCompany());
                }
                jobs.setJobDescription(jobsDTO.getJobDescription());
                jobs.setJobField(jobsDTO.getJobField());
                jobs.setJobStartDate(LocalDate.parse(jobsDTO.getJobStartDate()));
                jobs.setJobEndDate(LocalDate.parse(jobsDTO.getJobEndDate()));
                jobs.setJobIsFinished(jobsDTO.getJobIsFinished());
                jobs.setDegreeRequierd(jobsDTO.getDegreeRequierd());
                jobs.setGenderToJob(jobsDTO.getGenderToJob());
                jobs.setJobTime(jobsDTO.getJobTime());
                return  jobsRepository.save(jobs);

            }

    }
    @Override
    @Transactional
    public void UpdateJob(JobsDTO jobsDTO){

        Jobs jobs=jobsRepository.findById(jobsDTO.getJobId()).orElse(null);
        if(jobs == null){
            return ;
        }
        if(jobsDTO.getJobCompany()!= null){jobs.setCompanyID(jobsDTO.getJobCompany());}
        if(jobsDTO.getJobDescription()!=null){jobs.setJobDescription(jobsDTO.getJobDescription());}
        if(jobsDTO.getJobField()!=null){jobs.setJobField(jobsDTO.getJobField());}
        if(jobsDTO.getJobStartDate()!=null){jobs.setJobStartDate(LocalDate.parse(jobsDTO.getJobStartDate()));}
        if(jobsDTO.getJobEndDate()!=null){jobs.setJobEndDate(LocalDate.parse(jobsDTO.getJobEndDate()));}
        if(jobsDTO.getJobIsFinished()!=null){jobs.setJobIsFinished(jobsDTO.getJobIsFinished());}
        if(jobsDTO.getDegreeRequierd()!=null){jobs.setDegreeRequierd(jobsDTO.getDegreeRequierd());}
        if(jobsDTO.getGenderToJob()!=null){jobs.setGenderToJob(jobsDTO.getGenderToJob());}
        if(jobsDTO.getJobTime()!=null){jobs.setJobTime(jobsDTO.getJobTime());}
    }

    @Override
    public Boolean deleteJob(int id) {
        Boolean exist=jobsRepository.existsById(id);
        if(!exist){
            System.out.println("job does not exist");
            return false ;
        }
        jobsRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Jobs> SearchJob(Jobs job) {
        select = "SELECT j FROM jobs j where ";
        if(job.getGenderToJob()!=null && job.getGenderToJob()!=""){
            select+="j.genderToJob = ?1 ";
        }

        if(job.getJobField()!=null && job.getJobField()!=""){
            select+="AND j.jobField = ?2 ";
        }

        if(job.getJobTime()!=null && job.getJobTime()!=""){
            select+="AND j.jobTime = ?3 ";
        }

        if(job.getDegreeRequierd()!=null && job.getDegreeRequierd()!=""){
            select+="AND j.degreeRequierd = ?4 ";
        }
        return null ;
    }
}
