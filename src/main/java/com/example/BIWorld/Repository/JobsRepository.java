package com.example.BIWorld.Repository;

import com.example.BIWorld.Service.JobsServiceImp;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    String select = JobsServiceImp.select;

    Jobs findByJobId(int job_id);

    List<Jobs> findByCompanyID(Company companyID);

    List<Jobs> findByJobField(String jobfield);

    List<Jobs> findByGenderToJob(String GenderToJob);

    List<Jobs> findByDegreeRequierd(String DegreeRequierd);

    List<Jobs> findByJobTime(String JobTime);

    @Query("SELECT j FROM jobs j where j.jobField = ?1 and j.degreeRequierd = ?2 and  j.genderToJob = ?3 and j.companyID.cities.cityName = ?4")
    List<Jobs> findByAllData(String filed,
                             String degree,
                             String gender,
                             String city);

    List<Jobs> findByJobFieldAndGenderToJob(String jobfiled, String Gender);

    List<Jobs> findByJobFieldAndAndDegreeRequierd(String jobfield, String Degree);

    List<Jobs> findByJobFieldAndJobTime(String jobfield, String time);

    List<Jobs> findByJobFieldAndGenderToJobAndDegreeRequierd(String jobfield, String gender, String degree);

    List<Jobs> findByJobFieldAndGenderToJobAndJobTime(String jobfield, String gender, String jobtime);

    List<Jobs> findByJobFieldAndAndDegreeRequierdAndJobTime(String field, String time, String degree);

    List<Jobs> findByJobFieldAndDegreeRequierdAndGenderToJob(String field, String Degree, String Gender);

    List<Jobs> findByJobFieldAndJobTimeAndDegreeRequierd(String field, String time, String Degree);

    List<Jobs> findByGenderToJobAndJobFieldAndJobTimeAndDegreeRequierd(String gender, String filed, String time, String degreeRequierd);

    //        @Query()
//        List<Jobs> findall();


}
