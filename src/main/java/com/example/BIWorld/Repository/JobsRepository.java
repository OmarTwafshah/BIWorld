package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {
        List<Jobs> findByJobId(int job_id);
        List<Jobs> findByCompanyID(Company companyID );
        List<Jobs> findByJobField(String jobfield);
        List<Jobs> findByGenderToJob(String GenderToJob);
        List<Jobs> findByDegreeRequierd(String DegreeRequierd);
        List<Jobs> findByJobTime(String JobTime);
}
