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

    ;

}
