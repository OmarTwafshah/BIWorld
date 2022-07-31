package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterViewRepository extends JpaRepository<Interview,Integer> {
}
