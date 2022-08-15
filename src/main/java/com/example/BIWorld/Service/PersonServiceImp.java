package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.DTO.UserDTO;
import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;


    @Autowired
    public PersonServiceImp(PersonRepository personRepository, CompanyRepository companyRepository, CityRepository cityRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Person registerPerson(PersonDTO personDTO) {

        if (personRepository.findByUserName(personDTO.getUserName()).isEmpty() &&
                personRepository.findByPersonPhone(personDTO.getPersonPhone()).isEmpty() &&
                personRepository.findByPersonEmail(personDTO.getPersonEmail()).isEmpty() &&
                companyRepository.findByCompanyUserName(personDTO.getUserName()).isEmpty() &&
                companyRepository.findByCompanyEmail(personDTO.getPersonEmail()).isEmpty()) {
            Person person = new Person();
            person.setFullName(personDTO.getFullName());
            person.setUserName(personDTO.getUserName());
            //person.setCity(cityRepository.findBycity_id(city));
            if (!cityRepository.findBycity_id(personDTO.getCities().getCity_id()).isEmpty()) {
                person.setCity(personDTO.getCities());
            } else {
                System.out.println(personDTO.getCities().getCity_id() + " is not found ");
                return null;
            }
            person.setPersonEmail(personDTO.getPersonEmail());
            person.setPassword(personDTO.getPassword());
            person.setPersonPhone(personDTO.getPersonPhone());
            person.setPersonField(personDTO.getPersonField());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate =  LocalDate.parse(personDTO.getDateOfBirth(), format);
            person.setDateOfBirth(localDate);
            person.setGender(personDTO.getGender());
            person.setStudyDegree(personDTO.getStudyDegree());
            person.setDescription(personDTO.getDescription());
            person.setPicPath(personDTO.getPicPath());
            person.setInterests(personDTO.getInterests());
            return personRepository.save(person);
        } else {
            System.out.println("IsUSed");
            return null;
        }


    }

    @Override
    public Person authenticatePerson(String userName, String password) {
        System.out.println(userName);
        System.out.println(password);

        if (!personRepository.findByUserName(userName).isEmpty()) {
            System.out.println("The UserName Person true");
            return personRepository.findByUserNameAndPassword(userName, password).orElse(null);
        } else {
            System.out.println("The UserName Person wrong");
            return null;
        }
    }

    @Override
    @Transactional
    public void updatePerson(PersonDTO personDTO) {
        Person per = personRepository.findById(personDTO.getPerson_id()).orElse(null);
        if (personDTO.getFullName() != null) {
            per.setFullName(personDTO.getFullName());
        }
        if (personDTO.getUserName() != null) {
            per.setUserName(personDTO.getUserName());
        }
        if (personDTO.getCities() != null) {
            per.setCity(personDTO.getCities());
        }
        if (personDTO.getPersonEmail() != null) {
            per.setPersonEmail(personDTO.getPersonEmail());
        }
        if (personDTO.getPassword() != null) {
            per.setPassword(personDTO.getPassword());
        }
        if (personDTO.getPersonPhone() != null) {
            per.setPersonPhone(personDTO.getPersonPhone());
        }
        if (personDTO.getPersonField() != null) {
            per.setPersonField(personDTO.getPersonField());
        }
        if (personDTO.getDateOfBirth() != null) {
            per.setDateOfBirth(LocalDate.parse(personDTO.getDateOfBirth()));
        }
        if (personDTO.getGender() != null) {
            per.setGender(personDTO.getGender());
        }
        if (personDTO.getStudyDegree() != null) {
            per.setStudyDegree(personDTO.getStudyDegree());
        }
        if (personDTO.getDescription() != null) {
            per.setDescription(personDTO.getDescription());
        }
        if (personDTO.getPicPath() != null) {
            per.setPicPath(personDTO.getPicPath());
        }
        if (personDTO.getInterests() != null) {
            per.setInterests(personDTO.getInterests());
        }

    }

    @Override
    public List<Person> getPerson() {
        return personRepository.findAll();
    }


    @Override
    @Transactional
    public Boolean deletePerson(int id) {

        Boolean exist = personRepository.existsById(id);
        if (!exist) {
            System.out.println("person does not exist");
            return false;
        } else {
            personRepository.deleteById(id);
            return true;
        }
    }
}
