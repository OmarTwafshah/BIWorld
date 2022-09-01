package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface PersonService {
    Object registerPerson(
            PersonDTO personDTO) throws IOException;

    Person authenticatePerson(String userName, String password);

    void updatePerson(PersonDTO personDTO);

    List<Person> getPerson();

    Boolean deletePerson(int id);

    List<ApplicationPerson> ShowApplication(int id);

    Person getJustPerson(int id);

    ResponseEntity<Resource> getimage(int id) throws FileNotFoundException, MalformedURLException, Exception;
}
