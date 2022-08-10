package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;


    @Autowired
    public PersonService(PersonRepository personRepository, CompanyRepository companyRepository, CityRepository cityRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.cityRepository = cityRepository;
    }

    public Person registerPerson(
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
                                 String interests) {
        if (fullName == null
                || userName == null
                || personEmail == null
                || password == null
                || city == null
                || personPhone == null
                || personField == null
                || dateOfBirth == null
                || gender == null
                || studyDegree == null
                || description == null
                || picPath == null
                || interests == null) {
            System.out.println("ERORRRRRRRRRRR OMAr");
                    return null ;
                } else {
            if(personRepository.findByUserName(userName).isEmpty() &&
                    personRepository.findByPersonPhone(personPhone).isEmpty() &&
                    personRepository.findByPersonEmail(personEmail).isEmpty() &&
                    companyRepository.findByCompanyUserName(userName).isEmpty() &&
                    companyRepository.findByCompanyEmail(personEmail).isEmpty() ){
                Person person = new Person();
                person.setFullName(fullName);
                person.setUserName(userName);
                //person.setCity(cityRepository.findBycity_id(city));
                if(!cityRepository.findBycity_id(city.getCity_id()).isEmpty()){
                    person.setCity(city);
                }else {
                    System.out.println(city.getCity_id() +" is not found ");
                    return null;
                }
                person.setPersonEmail(personEmail);
                person.setPassword(password);
                person.setPersonPhone(personPhone);
                person.setPersonField(personField);
                person.setDateOfBirth(LocalDate.parse(dateOfBirth));
                person.setGender(gender);
                person.setStudyDegree(studyDegree);
                person.setDescription(description);
                person.setPicPath(picPath);
                person.setInterests(interests);
                return personRepository.save(person);
            }else {
                System.out.println("IsUSed");
                return null;
            }

        }

    }

    public Person authenticatePerson(String userName , String password ){
        System.out.println(userName);
        System.out.println(password);

        if(!personRepository.findByUserName(userName).isEmpty()){
            System.out.println("The UserName Person true");
            return personRepository.findByUserNameAndPassword(userName,password).orElse(null);
        }else {
            System.out.println("The UserName Person wrong");
            return null;
        }
    }
   @Transactional
   public void updatePerson(int id, String fullName,
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
                            String interests){
         Person per=personRepository.findById(id).orElseThrow(() -> new IllegalStateException("id is not found"));
         if(fullName != null){per.setFullName(fullName);}
         if(userName != null){per.setUserName(userName);}
         if(city != null){per.setCity(city);}
         if(personEmail != null){per.setPersonEmail(personEmail);}
         if(password != null){per.setPassword(password);}
         if(personPhone != null){per.setPersonPhone(personPhone);}
         if(personField != null){per.setPersonField(personField);}
         if(dateOfBirth != null){per.setDateOfBirth(LocalDate.parse(dateOfBirth));}
         if(gender != null){per.setGender(gender);}
         if(studyDegree != null){per.setStudyDegree(studyDegree);}
         if(description != null){per.setDescription(description);}
         if(picPath != null){per.setPicPath(picPath);}
         if(interests != null ){per.setInterests(interests);}

    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @Transactional
    public Boolean deletePerson(int id) {

        Boolean exist=personRepository.existsById(id);
        if(!exist){
            System.out.println("person does not exist");
            return false ;
        }else {
            personRepository.deleteById(id);
            return true;
        }
    }
}
