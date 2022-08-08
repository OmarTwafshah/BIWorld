package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;

    public static String select ;


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
                    companyID == null || jobDescription==null || jobField==null || jobStartDate==null
                    || jobEndDate== null || jobIsFinished==null
                    || degreeRequierd==null || genderToJob==null|| jobTime==null){
                return null;

            }else{
                Jobs jobs=new Jobs();
                if(companyRepository.findById(companyID.getCompany_id()).isEmpty()){
                    System.out.println(companyID.getCompany_id() +" is not found ");
                    return null;
                }else {
                    jobs.setCompanyID(companyID);
                }
                jobs.setJobDescription(jobDescription);
                jobs.setJobField(jobField);
                jobs.setJobStartDate(LocalDate.parse(jobStartDate));
                jobs.setJobEndDate(LocalDate.parse(jobEndDate));
                jobs.setJobIsFinished(jobIsFinished);
                jobs.setDegreeRequierd(degreeRequierd);
                jobs.setGenderToJob(genderToJob);
                jobs.setJobTime(jobTime);

                return  jobsRepository.save(jobs);

            }

    }
    @Transactional
    public void UpdateJob(int JobId,
                          Company companyID,
                          String jobDescription,
                          String jobField,
                          String jobStartDate,
                          String jobEndDate,
                          Boolean jobIsFinished,
                          String degreeRequierd,
                          String genderToJob,
                          String jobTime){

        Jobs jobs=jobsRepository.findById(JobId).orElse(null);
        if(jobs == null){
            return ;
        }
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

    public Boolean deleteJob(int id) {
        Boolean exist=jobsRepository.existsById(id);
        if(!exist){
            System.out.println("job does not exist");
            return false ;
        }
        jobsRepository.deleteById(id);
        return true;
    }

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
