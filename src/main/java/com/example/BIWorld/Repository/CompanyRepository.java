package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Optional<Company> findByCompanyUserNameAndCompanyPassword(String userName , String Password);

}
