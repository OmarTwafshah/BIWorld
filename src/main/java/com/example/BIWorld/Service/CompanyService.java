package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository ;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company registerCompany(String companyName,
                                  String companyUserName,
                                  String companyPassword,
                                  Set<City> cities,
                                  String companyDescription,
                                  Double companyPhone,
                                  Long companyFax,
                                  String companyEmail,
                                  Integer companyTax,
                                  String address){
        if (companyName == null
                || companyUserName == null
                || companyPassword == null
                || companyDescription == null
                || companyPhone == null
                || companyFax == null
                || companyEmail == null
                || companyTax == null
                || address == null) {
                    return null ;
                } else {
                    Company company = new Company();
                    company.setCompanyName(companyName);
                    company.setCompanyUserName(companyUserName);
                    company.setCompanyPassword(companyPassword);
                    company.setCities(cities);
                    company.setCompanyDescription(companyDescription);
                    company.setCompanyPhone(companyPhone);
                    company.setCompanyFax(companyFax);
                    company.setCompanyEmail(companyEmail);
                    company.setCompanyTax(companyTax);
                    company.setAddress(address);
                    return companyRepository.save(company);
                }
    }

    public Company authenticateCompany(String userName , String password ){
        if(companyRepository.findByCompanyUserName(userName)){
            return companyRepository.findByCompanyUserNameAndCompanyPassword(userName,password).orElse(null);
        }else {
            return null;
        }
    }

    public List<Company> getCompany(){
        return companyRepository.findAll();
    }
}
