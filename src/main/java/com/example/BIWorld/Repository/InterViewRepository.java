package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Interview;
import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface InterViewRepository extends JpaRepository<Interview,Integer> {

    @Query("SELECT i FROM interview i where i.interview_id = ?1")
    Interview findByInterview_id(Integer interview_id);

}
