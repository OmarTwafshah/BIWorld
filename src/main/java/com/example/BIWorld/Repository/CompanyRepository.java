package com.example.BIWorld.Repository;

import com.example.BIWorld.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Query("SELECT c FROM Company c where c.companyID = ?1")
    Company findByCompany_id(Integer company_id);

    Optional<Company> findByCompanyUserNameAndCompanyPassword(String userName , String Password);

    Optional<Company> findByCompanyUserName(String userName);

    Optional<Company> findByCompanyPhone(Double companyPhone);

    Optional<Company> findByCompanyFax(Long companyFax);

    Optional<Company> findByCompanyTax(Integer companyTax);

    Optional<Company> findByCompanyEmail(String companyEmail);


}
