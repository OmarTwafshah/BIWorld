package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {
        Optional<Jobs> findAllByJobId(long job_id);
}
