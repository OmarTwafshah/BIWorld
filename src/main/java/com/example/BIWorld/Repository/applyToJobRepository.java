package com.example.BIWorld.Repository;

import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;
import com.example.BIWorld.requests.ApplyToJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface applyToJobRepository extends JpaRepository<ApplyToJob,Integer> {
    @Query("SELECT i FROM apply_to_job i where i.application_id = ?1")
    ApplyToJob findByApplication_id(Integer Application_id);

    @Query("SELECT i FROM apply_to_job i where i.jobsToApplication.jobId = ?1 and i.myPersons.person_id = ?2")
    ApplyToJob findApplyToJobByApplication_idAndPersons(Integer jobId , Integer personId);

    @Query(value = "SELECT new com.example.BIWorld.requests.ApplyToJobInfo(i.myPersons.person_id,i.myPersons.fullName,i.myPersons.personEmail,i.myPersons.studyDegree,i.application_id,i.dateOfApplication,i.status) FROM apply_to_job i left join Company c on i.company.companyID=c.companyID left join persons p on i.myPersons.person_id=p.person_id left join jobs j on i.jobsToApplication.jobId=j.jobId where j.jobId = ?1 and c.companyID = ?2")
    List<ApplyToJobInfo> findByApplication_idAndCompany(Integer jobId , Integer companyID);
}
