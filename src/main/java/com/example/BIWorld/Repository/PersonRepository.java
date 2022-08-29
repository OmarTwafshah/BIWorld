package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM persons p where p.person_id = ?1")
    Person findByPerson_id(Integer Person_id);

    Optional<Person> findByUserNameAndPassword(String userName , String Password);

    Optional<Person> findByUserName(String userName);

    Optional<Person> findByPersonEmail(String personEmail);

    Optional<Person> findByPersonPhone(Double personPhone);
    @Query("SELECT p FROM persons p where p.userName = ?1")
    Person findByUserNameForConfig(String UserName);

}
