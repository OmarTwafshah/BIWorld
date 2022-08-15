package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.CompanyDTO;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;

import java.util.List;
import java.util.Set;

public interface CompanyService {

    Company registerCompany(CompanyDTO companyDTO);

    Company authenticateCompany(String userName, String password);

    List<Company> getCompany();

    void updatecompany(CompanyDTO companyDTO);

    Boolean deleteJob(int id);
}
