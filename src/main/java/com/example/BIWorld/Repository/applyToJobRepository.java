package com.example.BIWorld.Repository;

import com.example.BIWorld.models.ApplyToJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface applyToJobRepository extends JpaRepository<ApplyToJob,Integer> {
}
