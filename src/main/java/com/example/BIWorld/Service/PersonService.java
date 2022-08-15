package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;

import java.util.List;

public interface PersonService {
    Person registerPerson (
            PersonDTO personDTO) ;

    Person authenticatePerson(String userName , String password );

    void updatePerson(PersonDTO personDTO) ;

    List<Person> getPerson() ;

    Boolean deletePerson(int id);

}
