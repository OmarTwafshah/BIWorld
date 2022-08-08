package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findByUserNameAndPassword(String userName , String Password);

    Optional<Person> findByUserName(String userName);

    Optional<Person> findByPersonEmail(String personEmail);

    Optional<Person> findByPersonPhone(Double personPhone);

}
