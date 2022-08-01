package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
//    @Query("SELECT c FROM Company c where c.companyUserName = ?1 and c.companyPassword = ?2")
    Optional<Company> findByCompanyUserNameAndCompanyPassword(String userName , String Password);

}
