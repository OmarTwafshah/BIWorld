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

////    String FILTER_CUSTOMERS_ON_FIRST_NAME_AND_LAST_NAME_QUERY = "select j from Customer b where UPPER(b.firstName) like CONCAT('%',UPPER(?1),'%') and UPPER(b.lastName) like CONCAT('%',UPPER(?2),'%')";
//
//    @Query("")

    @Query("SELECT j FROM jobs j where j.jobField LIKE ?1 and j.degreeRequierd LIKE ?2 and  j.genderToJob LIKE ?3 and j.companyID.cities.cityName LIKE ?4")
    List<Jobs> findByAllData(String filed,
                             String degree,
                             String gender,
                             String city);

    ;

}
