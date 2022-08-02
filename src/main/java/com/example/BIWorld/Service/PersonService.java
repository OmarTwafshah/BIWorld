package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person registerPerson(Integer personId,
                                 String fullName,
                                 String userName,
                                 City city,
                                 String personEmail,
                                 String password,
                                 Double personPhone,
                                 String personField,
                                 String dateOfBirth,
                                 String gender,
                                 String studyDegree,
                                 String description,
                                 String picPath,
                                 String haveCV) {
        if (fullName == null
                || userName == null
                || personEmail == null
                || password == null
                || personPhone == null
                || personField == null
                || gender == null
                || studyDegree == null
                || description == null
                || picPath == null) {
            System.out.println("ERORRRRRRRRRRR OMAr");
                    return null ;
                } else {
            if(personRepository.findByUserNameAndPersonEmailAndPersonPhone(userName, personEmail, personPhone).isEmpty()){
                Person person = new Person();
                person.setPerson_id(personId);
                person.setFullName(fullName);
                person.setUserName(userName);
                person.setCity(city);
                person.setPersonEmail(personEmail);
                person.setPassword(password);
                person.setPersonPhone(personPhone);
                person.setPersonField(personField);
                person.setDateOfBirth(LocalDate.parse(dateOfBirth));
                person.setGender(gender);
                person.setStudyDegree(studyDegree);
                person.setDescription(description);
                person.setPicPath(picPath);
                person.setHaveCV(Boolean.parseBoolean(haveCV));
                return personRepository.save(person);
            }else {
                return null;
            }

        }

    }

    public Person authenticatePerson(String userName , String password ){
        if(!personRepository.findByUserName(userName).isEmpty()){
            return personRepository.findByUserNameAndPassword(userName,password).orElse(null);
        }else {
            return null;
        }
    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

}
