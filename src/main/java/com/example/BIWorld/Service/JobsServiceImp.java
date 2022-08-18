package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.FilterJobs;
import com.example.BIWorld.requests.SearchRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobsServiceImp implements JobsService {
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;


    @PersistenceContext
    private EntityManager entityManager;


    public JobsServiceImp(JobsRepository jobsRepository, CompanyRepository companyRepository, CityRepository cityRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Jobs> Showjobs(FilterJobs filterJobs) {
        return jobsRepository.findByAllData(filterJobs.getPersonField(), filterJobs.getStudyDegree(), filterJobs.getGender(), filterJobs.getCity());
    }

    @Override
    public Jobs add(JobsDTO jobsDTO) {

        if (jobsDTO.getJobTitle() == null ||
                jobsDTO.getJobDescription() == null || jobsDTO.getJobField() == null || jobsDTO.getJobStartDate() == null
                || jobsDTO.getJobEndDate() == null || jobsDTO.getJobIsFinished() == null
                || jobsDTO.getDegreeRequierd() == null || jobsDTO.getGenderToJob() == null || jobsDTO.getJobTime() == null) {
            return null;

        } else {
            Jobs jobs = new Jobs();

            jobs.setCompanyID(companyRepository.findByCompany_id(Integer.parseInt(jobsDTO.getCompanyID())));
            jobs.setJobTitle(jobsDTO.getJobTitle());
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
        if (jobsDTO.getJobTitle() != null) {
            jobs.setJobTitle(jobsDTO.getJobTitle());
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

    @Override
    public List<Jobs> SearchJob(SearchRequest searchRequest) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM jobs j left join companies c on j.companyid=c.company_id left join cities i on c.city_id=i.city_id where 1=1 ");
        if (searchRequest.getGender() != null && searchRequest.getGender() != "") {
            sql.append("AND j.gender_to_job ILIKE :gender ");
            params.put("gender", "%" + searchRequest.getGender() + "%");
        }

        if (searchRequest.getJobTime() != null && searchRequest.getJobTime() != "") {
            sql.append("AND j.job_time ILIKE :field ");
            params.put("field", searchRequest.getJobTime());
        }

        if (searchRequest.getCity() != null && searchRequest.getCity() != "") {
            sql.append("AND i.city_name ILIKE :city ");
            params.put("city", searchRequest.getCity());
        }

        Query query = entityManager.createNativeQuery(sql.toString(), Jobs.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();

    }
}
