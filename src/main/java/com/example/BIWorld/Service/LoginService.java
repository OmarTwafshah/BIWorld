package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    private final PersonRepository personRepository ;
    private final CompanyRepository companyRepository ;


    public LoginService(PersonRepository personRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUserNameForConfig(username);
        if(person != null){
            return new User(person.getUserName(),person.getPassword(),new ArrayList<>());
        }
        Company company = companyRepository.findByUserNameForConfig(username);
        if(company != null){
            return new User(company.getCompanyUserName(),company.getCompanyPassword(),new ArrayList<>());
        }
        return null ;
    }
}
