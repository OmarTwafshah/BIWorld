package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.CompanyDTO;
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
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    private final PersonRepository personRepository;

    private final CityRepository cityRepository;


    public CompanyServiceImp(CompanyRepository companyRepository, PersonRepository personRepository, CityRepository cityRepository) {
        this.companyRepository = companyRepository;
        this.personRepository = personRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Company registerCompany(CompanyDTO companyDTO) {
        if (companyDTO.getCompanyName() == null && companyDTO.getCompanyName() == " "
                || companyDTO.getUsername() == null
                || companyDTO.getPassword() == null
                || companyDTO.getCity() == null
                || companyDTO.getCompdescription() == null
                || companyDTO.getPhone() == null
                || companyDTO.getFax() == null
                || companyDTO.getEmail() == null
                || companyDTO.getTax() == null
                || companyDTO.getAddress() == null) {
            return null;
        } else {
            if (personRepository.findByUserName(companyDTO.getUsername()).isEmpty() &&
                    personRepository.findByPersonEmail(companyDTO.getEmail()).isEmpty() &&
                    companyRepository.findByCompanyUserName(companyDTO.getUsername()).isEmpty() &&
                    companyRepository.findByCompanyEmail(companyDTO.getEmail()).isEmpty() &&
                    companyRepository.findByCompanyFax(companyDTO.getFax()).isEmpty() &&
                    companyRepository.findByCompanyTax(companyDTO.getTax()).isEmpty() &&
                    companyRepository.findByCompanyPhone(companyDTO.getPhone()).isEmpty()) {
                Company company = new Company();
                company.setCompanyName(companyDTO.getCompanyName());
                company.setCompanyUserName(companyDTO.getUsername());
                company.setCompanyPassword(companyDTO.getPassword());
                City city = cityRepository.findByCityName(companyDTO.getCity());
                if (city != null ) {
                    company.setCities(city);
                } else {
                    System.out.println(companyDTO.getCity() + " is not found ");
                    return null;
                }
                company.setCompanyDescription(companyDTO.getCompdescription());
                company.setCompanyPhone(companyDTO.getPhone());
                company.setCompanyFax(companyDTO.getFax());
                company.setCompanyEmail(companyDTO.getEmail());
                company.setCompanyTax(companyDTO.getTax());
                company.setAddress(companyDTO.getAddress());
                return companyRepository.save(company);

            } else {
                System.out.println("IsUSed");
                return null;
            }

        }
    }

    @Override
    public Company authenticateCompany(String userName, String password) {
        if (!companyRepository.findByCompanyUserName(userName).isEmpty()) {
            System.out.println("The UserName Company true");
            return companyRepository.findByCompanyUserNameAndCompanyPassword(userName, password).orElse(null);
        } else {
            System.out.println("The UserName Company wrong");
            return null;
        }
    }

    @Override
    public List<Company> getCompany() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void updatecompany(CompanyDTO companyDTO) {
        Company comp = companyRepository.findById(companyDTO.getCompanyID()).orElse(null);
        if (companyDTO.getCompdescription() != null) {
            comp.setCompanyDescription(companyDTO.getCompdescription());
        }
        if (companyDTO.getCompanyName() != null) {
            comp.setCompanyName(companyDTO.getCompanyName());
        }
        if (companyDTO.getUsername() != null) {
            comp.setCompanyUserName(companyDTO.getUsername());
        }
        if (companyDTO.getPassword() != null) {
            comp.setCompanyPassword(companyDTO.getPassword());
        }
        if (companyDTO.getEmail() != null) {
            comp.setCompanyEmail(companyDTO.getEmail());
        }
        if (companyDTO.getCity() != null) {
            City city = cityRepository.findByCityName(companyDTO.getCity());
            if (city != null ) {
                comp.setCities(city);
            }
        }
        if (companyDTO.getFax() != null) {
            comp.setCompanyFax(companyDTO.getFax());
        }
        if (companyDTO.getPhone() != null) {
            comp.setCompanyPhone(companyDTO.getPhone());
        }
        if (companyDTO.getTax() != null) {
            comp.setCompanyTax(companyDTO.getTax());
        }
        if (companyDTO.getAddress() != null) {
            comp.setAddress(companyDTO.getAddress());
        }
    }

    @Override
    public Boolean deleteJob(int id) {
        Boolean exist = companyRepository.existsById(id);
        if (!exist) {
            System.out.println("company does not exist");
            return false;
        } else {
            companyRepository.deleteById(id);
            return true;
        }
    }
}
