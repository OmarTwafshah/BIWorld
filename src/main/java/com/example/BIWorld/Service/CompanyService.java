package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository ;

    private final PersonRepository personRepository;

    private final CityRepository cityRepository;


    @Autowired
    public CompanyService(CompanyRepository companyRepository, PersonService personService, PersonRepository personRepository, CityRepository cityRepository, CityRepository cityRepository1) {
        this.companyRepository = companyRepository;
        this.personRepository = personRepository;
        this.cityRepository = cityRepository1;
    }

    public Company registerCompany(
                                  String companyName,
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
                    if(companyRepository.findByCompanyUserNameAndCompanyPhoneAndCompanyFaxAndCompanyEmailAndCompanyTax(
                            companyUserName,
                            companyPhone,
                            companyFax,
                            companyEmail,
                            companyTax).isEmpty() && personRepository.findByUserNameAndPersonEmail(companyUserName,companyEmail).isEmpty()){
                        Company company = new Company();
                        company.setCompanyName(companyName);
                        company.setCompanyUserName(companyUserName);
                        company.setCompanyPassword(companyPassword);
                        company.setCompanyDescription(companyDescription);
                        company.setCompanyPhone(companyPhone);
                        company.setCompanyFax(companyFax);
                        company.setCompanyEmail(companyEmail);
                        company.setCompanyTax(companyTax);
                        company.setAddress(address);
                        Company createdCompany1 = companyRepository.save(company);
                        Set<Company> companies = new HashSet<>();
                        companies.add(createdCompany1);
                        for (Iterator<City> it = cities.iterator(); it.hasNext(); ) {
                            City f = it.next();
                            f.setCompanies(companies);
                            cityRepository.save(f);
                        }
                        return company;

                    }else {
                        System.out.println("IsUSed");
                        return null ;
                    }

                }
    }

    public Company authenticateCompany(String userName , String password ){
        if(!companyRepository.findByCompanyUserName(userName).isEmpty()){
            return companyRepository.findByCompanyUserNameAndCompanyPassword(userName,password).orElse(null);
        }else {
            return null;
        }
    }

    public List<Company> getCompany(){
        return companyRepository.findAll();
    }

   @Transactional
   public void updatecompany(int companyId,
                             String companyName,
                             String companyUserName,
                             String companyPassword,
                             Set<City> cities,
                             String companyDescription,
                             Double companyPhone,
                             Long companyFax,
                             String companyEmail,
                             Integer companyTax,
                             String address) {
        Company comp=companyRepository.findById(companyId).orElseThrow(() -> new IllegalStateException("id is not found"));
        if(companyDescription != null){comp.setCompanyDescription(companyDescription);}
        if(companyName != null){comp.setCompanyName(companyName);}
        if(companyUserName != null){comp.setCompanyUserName(companyUserName);}
        if(companyPassword != null){comp.setCompanyPassword(companyPassword);}
        if(companyEmail != null){comp.setCompanyEmail(companyEmail);}
        if(cities != null){comp.setCities(cities);}
        if(companyFax != null){comp.setCompanyFax(companyFax);}
        if(companyPhone != null){comp.setCompanyPhone(companyPhone);}
        if(companyTax != null){comp.setCompanyTax(companyTax);}
        if(address != null){comp.setAddress(address);}
    }

    public void deleteJob(int id) {
        Boolean exist=companyRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("company does not exist");
        }
        companyRepository.deleteById(id);
    }
}
