package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person registerPerson(String fullName,
                                 String userName,
                                 City city,
                                 String personEmail,
                                 String password,
                                 Double personPhone,
                                 String personField,
                                 LocalDate dateOfBirth,
                                 String gender,
                                 String studyDegree,
                                 String description,
                                 String picPath,
                                 boolean haveCV) {
        if (fullName == null
                || userName == null
                || city == null
                || personEmail == null
                || password == null
                || personPhone == null
                || personField == null
                || dateOfBirth == null
                || gender == null
                || studyDegree == null
                || description == null
                || picPath == null) {
                    return null ;
                } else {
            Person person = new Person();
            person.setFullName(fullName);
            person.setUserName(userName);
            person.setCity(city);
            person.setPersonEmail(personEmail);
            person.setPassword(password);
            person.setPersonPhone(personPhone);
            person.setPersonField(personField);
            person.setDateOfBirth(dateOfBirth);
            person.setGender(gender);
            person.setStudyDegree(studyDegree);
            person.setDescription(description);
            person.setPicPath(picPath);
            person.setHaveCV(haveCV);
            return personRepository.save(person);
        }

    }

    public Person authenticatePerson(String userName , String password ){
        if(personRepository.findByUserName(userName)){
            return personRepository.findByUserNameAndPassword(userName,password).orElse(null);
        }else {
            return null;
        }
    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

}
