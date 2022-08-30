package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PersonService {
    Object registerPerson (
            PersonDTO personDTO, MultipartFile multipartFile) throws IOException;

    Person authenticatePerson(String userName , String password );

    void updatePerson(PersonDTO personDTO) ;

    List<Person> getPerson() ;

    Boolean deletePerson(int id);

    List<ApplicationPerson> ShowApplication(int id);
}
