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
        if (companyDTO.getCompanyName() == null
                || companyDTO.getCompanyUserName() == null
                || companyDTO.getCompanyPassword() == null
                || companyDTO.getCities() == null
                || companyDTO.getCompanyDescription() == null
                || companyDTO.getCompanyPhone() == null
                || companyDTO.getCompanyFax() == null
                || companyDTO.getCompanyEmail() == null
                || companyDTO.getCompanyTax() == null
                || companyDTO.getAddress() == null) {
            return null;
        } else {
            if (personRepository.findByUserName(companyDTO.getCompanyUserName()).isEmpty() &&
                    personRepository.findByPersonEmail(companyDTO.getCompanyEmail()).isEmpty() &&
                    companyRepository.findByCompanyUserName(companyDTO.getCompanyUserName()).isEmpty() &&
                    companyRepository.findByCompanyEmail(companyDTO.getCompanyEmail()).isEmpty() &&
                    companyRepository.findByCompanyFax(companyDTO.getCompanyFax()).isEmpty() &&
                    companyRepository.findByCompanyTax(companyDTO.getCompanyTax()).isEmpty() &&
                    companyRepository.findByCompanyPhone(companyDTO.getCompanyPhone()).isEmpty()) {
                Company company = new Company();
                company.setCompanyName(companyDTO.getCompanyName());
                company.setCompanyUserName(companyDTO.getCompanyUserName());
                company.setCompanyPassword(companyDTO.getCompanyPassword());
                if (!cityRepository.findBycity_id(companyDTO.getCities().getCity_id()).isEmpty()) {
                    company.setCities(companyDTO.getCities());
                } else {
                    System.out.println(companyDTO.getCities().getCity_id() + " is not found ");
                    return null;
                }
                company.setCompanyDescription(companyDTO.getCompanyDescription());
                company.setCompanyPhone(companyDTO.getCompanyPhone());
                company.setCompanyFax(companyDTO.getCompanyFax());
                company.setCompanyEmail(companyDTO.getCompanyEmail());
                company.setCompanyTax(companyDTO.getCompanyTax());
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
        if (companyDTO.getCompanyDescription() != null) {
            comp.setCompanyDescription(companyDTO.getCompanyDescription());
        }
        if (companyDTO.getCompanyName() != null) {
            comp.setCompanyName(companyDTO.getCompanyName());
        }
        if (companyDTO.getCompanyUserName() != null) {
            comp.setCompanyUserName(companyDTO.getCompanyUserName());
        }
        if (companyDTO.getCompanyPassword() != null) {
            comp.setCompanyPassword(companyDTO.getCompanyPassword());
        }
        if (companyDTO.getCompanyEmail() != null) {
            comp.setCompanyEmail(companyDTO.getCompanyEmail());
        }
        if (companyDTO.getCities() != null) {
            comp.setCities(companyDTO.getCities());
        }
        if (companyDTO.getCompanyFax() != null) {
            comp.setCompanyFax(companyDTO.getCompanyFax());
        }
        if (companyDTO.getCompanyPhone() != null) {
            comp.setCompanyPhone(companyDTO.getCompanyPhone());
        }
        if (companyDTO.getCompanyTax() != null) {
            comp.setCompanyTax(companyDTO.getCompanyTax());
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
