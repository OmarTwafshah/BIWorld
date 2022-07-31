package com.example.BIWorld.Repository;

import com.example.BIWorld.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
}
