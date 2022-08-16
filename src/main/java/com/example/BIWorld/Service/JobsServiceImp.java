package com.example.BIWorld.Service;

import com.example.BIWorld.Controller.LoginController;
import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.SearchRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JobsServiceImp implements JobsService {
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;

    public static String select;


    public JobsServiceImp(JobsRepository jobsRepository, CompanyRepository companyRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Jobs> Showjobs() {
        return jobsRepository.findAll();
    }

    public List<Jobs> getJobsByFiled(String jobFiled) {
        return jobsRepository.findByJobField(jobFiled);
    }

    public List<Jobs> getJobByGender(String Gender) {
        return jobsRepository.findByGenderToJob(Gender);
    }

    public List<Jobs> getJobByDegree(String Degree) {
        return jobsRepository.findByDegreeRequierd(Degree);
    }

    public List<Jobs> getJobByTime(String Time) {
        return jobsRepository.findByJobTime(Time);
    }

    public List<Jobs> getJobByCompany(Company CompanyId) {
        return jobsRepository.findByCompanyID(CompanyId);
    }

    @Override
    public Jobs add(JobsDTO jobsDTO) {

        if (
                jobsDTO.getJobDescription() == null || jobsDTO.getJobField() == null || jobsDTO.getJobStartDate() == null
                        || jobsDTO.getJobEndDate() == null || jobsDTO.getJobIsFinished() == null
                        || jobsDTO.getDegreeRequierd() == null || jobsDTO.getGenderToJob() == null || jobsDTO.getJobTime() == null) {
            return null;

        } else {
            Jobs jobs = new Jobs();

            jobs.setCompanyID(LoginController.companyAll);
            jobs.setJobDescription(jobsDTO.getJobDescription());
            jobs.setJobField(jobsDTO.getJobField());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(jobsDTO.getJobStartDate(), format);
            jobs.setJobStartDate(localDate);
            LocalDate localDate2 = LocalDate.parse(jobsDTO.getJobEndDate(), format);
            jobs.setJobEndDate(localDate2);
            jobs.setJobIsFinished(jobsDTO.getJobIsFinished());
            jobs.setDegreeRequierd(jobsDTO.getDegreeRequierd());
            jobs.setGenderToJob(jobsDTO.getGenderToJob());
            jobs.setJobTime(jobsDTO.getJobTime());
            return jobsRepository.save(jobs);

        }

    }

    @Override
    @Transactional
    public void UpdateJob(JobsDTO jobsDTO) {

        Jobs jobs = jobsRepository.findById(jobsDTO.getJobId()).orElse(null);
        if (jobs == null) {
            return;
        }
        if (jobsDTO.getJobDescription() != null) {
            jobs.setJobDescription(jobsDTO.getJobDescription());
        }
        if (jobsDTO.getJobField() != null) {
            jobs.setJobField(jobsDTO.getJobField());
        }
        if (jobsDTO.getJobStartDate() != null) {
            jobs.setJobStartDate(LocalDate.parse(jobsDTO.getJobStartDate()));
        }
        if (jobsDTO.getJobEndDate() != null) {
            jobs.setJobEndDate(LocalDate.parse(jobsDTO.getJobEndDate()));
        }
        if (jobsDTO.getJobIsFinished() != null) {
            jobs.setJobIsFinished(jobsDTO.getJobIsFinished());
        }
        if (jobsDTO.getDegreeRequierd() != null) {
            jobs.setDegreeRequierd(jobsDTO.getDegreeRequierd());
        }
        if (jobsDTO.getGenderToJob() != null) {
            jobs.setGenderToJob(jobsDTO.getGenderToJob());
        }
        if (jobsDTO.getJobTime() != null) {
            jobs.setJobTime(jobsDTO.getJobTime());
        }
    }

    @Override
    public Boolean deleteJob(int id) {
        Boolean exist = jobsRepository.existsById(id);
        if (!exist) {
            System.out.println("job does not exist");
            return false;
        }
        jobsRepository.deleteById(id);
        return true;
    }

//    @Override
//    public List<Jobs> SearchJob(SearchRequest searchRequest) {
//        if ((searchRequest.getGender() != null && searchRequest.getGender() != "")){
//
//        }
//
//        if ((searchRequest.getGender() != null && searchRequest.getGender() != "")
//                && (searchRequest.getFiled() != null && searchRequest.getFiled() != "")
//                && (searchRequest.getJobTime() != null && searchRequest.getJobTime() != "")
//                && (searchRequest.getDegreeRequierd() == null || searchRequest.getDegreeRequierd() == "")) {
//            return jobsRepository.findByGenderToJobAndJobFieldAndJobTimeAndDegreeRequierd(searchRequest.getGender(),
//                    searchRequest.getFiled(),
//                    searchRequest.getJobTime(),
//                    searchRequest.getDegreeRequierd());
//        }
//
//        return null;
//    }
}
