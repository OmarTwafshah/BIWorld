package com.example.BIWorld.Service;

import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;

import java.util.List;

public interface PersonService {
    Person registerPerson (
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
            String interests) ;

    Person authenticatePerson(String userName , String password );

    void updatePerson(int id, String fullName,
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
                      String interests) ;

    List<Person> getPerson() ;

    Boolean deletePerson(int id);

}
