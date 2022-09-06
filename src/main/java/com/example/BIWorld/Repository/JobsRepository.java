package com.example.BIWorld.Repository;


import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.Jobs_show;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BIWorld.models.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    Jobs findByJobId(int job_id);

    @Query(value = "SELECT j  FROM jobs j left join Company c on j.companyID.companyID=c.companyID left join cities i on c.cities.city_id=i.city_id where j.jobField LIKE ?1 and j.degreeRequierd LIKE ?2 and  (j.genderToJob like ?3 or j.genderToJob like 'any') and i.cityName LIKE ?4")
    List<Jobs> findByAllData(String filed,
                             String degree,
                             String gender,
                             String city);

//@Query(value = "SELECT * FROM jobs j left join Company c on j.companyID.companyID=c.companyID left join cities i on c.cities.city_id=i.city_id where ")
//List<Jobs_show> SearchJob(String filed,
//                              String degree,
//                              String gender,
//                              String city);
}
