package com.example.BIWorld.Repository;

import com.example.BIWorld.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("SELECT c FROM cities c where c.city_id = ?1")
    City findBycity_id(Integer integer);

}
