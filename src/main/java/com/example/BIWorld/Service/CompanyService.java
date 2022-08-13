package com.example.BIWorld.Service;

import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;

import java.util.List;
import java.util.Set;

public interface CompanyService {

    Company registerCompany(
            String companyName,
            String companyUserName,
            String companyPassword,
            Set<City> cities,
            String companyDescription,
            Double companyPhone,
            Long companyFax,
            String companyEmail,
            Integer companyTax,
            String address);

    Company authenticateCompany(String userName, String password);

    List<Company> getCompany();

    void updatecompany(int companyId,
                  String companyName,
                  String companyUserName,
                  String companyPassword,
                  Set<City> cities,
                  String companyDescription,
                  Double companyPhone,
                  Long companyFax,
                  String companyEmail,
                  Integer companyTax,
                  String address);

    Boolean deleteJob(int id);
}
