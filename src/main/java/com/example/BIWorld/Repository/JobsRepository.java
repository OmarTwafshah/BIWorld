package com.example.BIWorld.Repository;


import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.requests.jobs_show;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BIWorld.models.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    Jobs findByJobId(int job_id);

////    String FILTER_CUSTOMERS_ON_FIRST_NAME_AND_LAST_NAME_QUERY = "select j from Customer b where UPPER(b.firstName) like CONCAT('%',UPPER(?1),'%') and UPPER(b.lastName) like CONCAT('%',UPPER(?2),'%')";
//
//    @Query("")

@Query(value = "select j FROM jobs j where j.jobField LIKE ?1 and j.degreeRequierd LIKE ?2 and  j.genderToJob  LIKE ?3 and j.companyID.cities.cityName LIKE ?4")
//@Query(value = "select new com.example.BIWorld.DTO.JobsDTO(j.jobId,j.jobTitle) , j.jobField,c.companyName,i.cityName FROM jobs j left join  Company c on c.companyID=j.companyID.companyID left join cities i on i.city_id=c.cities.city_id where j.jobField LIKE ?1 and j.degreeRequierd LIKE ?2 and  j.genderToJob  LIKE ?3 and j.companyID.cities.cityName LIKE ?4")
List<Jobs> findByAllData(String filed,
                                  String degree,
                                  String gender,
                                  String city);

    ;

}
