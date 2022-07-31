package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {

}
