package com.example.BIWorld.Repository;

import com.example.BIWorld.Service.JobsService;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {

        String select = JobsService.select;

        List<Jobs> findByJobId(int job_id);
        List<Jobs> findByCompanyID(Company companyID );
        List<Jobs> findByJobField(String jobfield);
        List<Jobs> findByGenderToJob(String GenderToJob);
        List<Jobs> findByDegreeRequierd(String DegreeRequierd);
        List<Jobs> findByJobTime(String JobTime);
        List<Jobs> findByJobFieldAndGenderToJob(String jobfiled,String Gender);
        List<Jobs> findByJobFieldAndAndDegreeRequierd(String jobfield, String Degree);
        List<Jobs> findByJobFieldAndJobTime(String jobfield,String time);
        List<Jobs> findByJobFieldAndGenderToJobAndDegreeRequierd(String jobfield,String gender,String degree);
        List<Jobs> findByJobFieldAndGenderToJobAndJobTime(String jobfield,String gender,String jobtime);
        List<Jobs> findByJobFieldAndAndDegreeRequierdAndJobTime(String field, String time,String degree);
        List<Jobs> findByJobFieldAndDegreeRequierdAndGenderToJob(String field, String Degree,String Gender);
        List<Jobs> findByJobFieldAndJobTimeAndDegreeRequierd(String field,String time,String Degree);

//        @Query()
//        List<Jobs> findall();




}
