package com.example.BIWorld.Service;

import com.example.BIWorld.Controller.LoginController;
import com.example.BIWorld.DTO.JobsDTO;
import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.JobsRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class JobsServiceImp implements JobsService {
    private final JobsRepository jobsRepository;

    private final CompanyRepository companyRepository;

    private final applyToJobRepository repository;

    private final CityRepository cityRepository;


    @PersistenceContext
    private EntityManager entityManager;


    public JobsServiceImp(JobsRepository jobsRepository, CompanyRepository companyRepository, applyToJobRepository repository, CityRepository cityRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
        this.repository = repository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Jobs_show> Showjobs(FilterJobs filterJobs) {
        return jobsRepository.findByAllData(filterJobs.getPersonField(), filterJobs.getStudyDegree(), filterJobs.getGender(), filterJobs.getCity());
    }

    @Override
    public Object add(JobsDTO jobsDTO) {

        if (jobsDTO.getJobTitle() == null ||
                jobsDTO.getJobDescription() == null || jobsDTO.getJobField() == null
                || jobsDTO.getEndDate() == null
                || jobsDTO.getStudyDegree() == null || jobsDTO.getGender() == null || jobsDTO.getJobTime() == null) {
            return "One filed is empty";

        } else {
            Jobs jobs = new Jobs();
            jobs.setCompanyID(companyRepository.findByCompany_id(jobsDTO.getCompanyID()));
            jobs.setJobTitle(jobsDTO.getJobTitle());
            jobs.setJobDescription(jobsDTO.getJobDescription());
            jobs.setJobField(jobsDTO.getJobField());
            LocalDate currentDateTime = LocalDate.from(LocalDate.now());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            jobs.setJobStartDate(currentDateTime);
            LocalDate localDate = LocalDate.parse(jobsDTO.getEndDate(), format);
            jobs.setJobEndDate(localDate);
            jobs.setJobIsFinished(false);
            jobs.setDegreeRequierd(jobsDTO.getStudyDegree());
            jobs.setGenderToJob(jobsDTO.getGender());
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

        if (jobsDTO.getJobIsFinished() != null) {
            jobs.setJobIsFinished(jobsDTO.getJobIsFinished());
        }
        if (jobsDTO.getStudyDegree() != null) {
            jobs.setDegreeRequierd(jobsDTO.getStudyDegree());
        }
        if (jobsDTO.getGender() != null) {
            jobs.setGenderToJob(jobsDTO.getGender());
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
        if (searchRequest.getGender() != null && !searchRequest.getGender().isEmpty() && !searchRequest.getGender().equalsIgnoreCase("null")) {
            if (searchRequest.getGender().equals("Male")) {
                sql.append("AND j.gender_to_job != 'Female' ");
            } else {
                sql.append("AND j.gender_to_job != 'Male' ");
            }
//            sql.append("AND j.gender_to_job = :gender OR j.gender_to_job = 'any' ");
//            params.put("gender", "%" + searchRequest.getGender() + "%");

        }

        if (searchRequest.getPersonField() != null && searchRequest.getPersonField() != "" && searchRequest.getPersonField() != "null") {
            sql.append("AND j.job_field ILIKE :field ");
            params.put("field", searchRequest.getPersonField());
        }

        if (searchRequest.getStudyDegree() != null && searchRequest.getStudyDegree() != "" && searchRequest.getStudyDegree() != "null") {
            sql.append("AND j.degree_requierd ILIKE :degree ");
            params.put("degree", searchRequest.getStudyDegree());
        }

        if (searchRequest.getCity() != null && searchRequest.getCity() != "" && searchRequest.getCity() != "null") {
            sql.append("AND i.city_name ILIKE :city ");
            params.put("city", searchRequest.getCity());
        }
        System.out.println(searchRequest);
        Query query = entityManager.createNativeQuery(sql.toString(), Jobs.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();

    }
//    @Override
//    public List<Jobs> SearchJob(Map<JobsServiceImp.Search, Object> feilds) {
//        try {
//            String query = "SELECT * FROM jobs j left join companies c on j.companyid=c.company_id left join cities i on c.city_id=i.city_id where %s";
//            StringJoiner joiner = new StringJoiner(" AND ");
//            for (Search search : feilds.keySet()) {
//                joiner.add(String.format(search.toString(), feilds.get(search)));
//            }
//            System.out.println(String.format(query, joiner));
//            Query res = entityManager.createNativeQuery(String.format(query, joiner), Jobs.class);
//            return res.getResultList();
//        } catch (Exception exception) {
//            System.out.println("please check the inputs");
//        }
//        return null;
//    }

    @Override
    public Object getInfo(JobDetails jobDetails) {
        ArrayList<Object> arr = new ArrayList<>();
        if (jobDetails == null) {
            return "Empty";
        }

        Jobs job = jobsRepository.findByJobId(jobDetails.getJobID());
        arr.add(job);
        if(LoginController.type.equalsIgnoreCase("person")){
            ApplyToJob applyToJob = repository.findApplyToJobByApplication_idAndPersons(jobDetails.getJobID(), jobDetails.getId());
            if (applyToJob == null) {
                arr.add(false);
            } else {
                arr.add(true);
                arr.add(repository.findApplyToJobByApplication_idAndPersons(jobDetails.getJobID(), jobDetails.getId()).getStatus());
            }
        }else if(LoginController.type.equalsIgnoreCase("company")){
            List<ApplyToJobInfo> applyToJob = repository.findByApplication_idAndCompany(jobDetails.getJobID(), jobDetails.getId());
            if (applyToJob == null) {
                arr.add(false);
            } else {
                arr.add(true);
                arr.add(applyToJob);
            }
        }


        return arr;
    }

    public enum Search {
        CITY {
            @Override
            public String toString() {
                return "i.city_name=%s";
            }
        },
        GENDER {
            @Override
            public String toString() {
                return "j.gender_to_job!=%s";
            }
        },
        FILED {
            @Override
            public String toString() {
                return "j.job_filed=%s";
            }
        },
        STUDYDEGREE {
            @Override
            public String toString() {
                return "j.degree_requierd=%s";
            }
        };
    }


}
