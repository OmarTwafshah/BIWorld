package com.example.BIWorld.Repository;

import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface applyToJobRepository extends JpaRepository<ApplyToJob,Integer> {
    @Query("SELECT i FROM apply_to_job i where i.application_id = ?1")
    ApplyToJob findByApplication_id(Integer Application_id);

    @Query("SELECT i FROM apply_to_job i where i.application_id = ?1 and i.myPersons.person_id = ?2")
    Optional<ApplyToJob> findApplyToJobByApplication_idAndPersons(Integer Application_id , Integer personId);
}
