package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    private final applyToJobRepository repository;

    private final PersonRepository personRepository;

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;


    @Autowired
    public PersonServiceImp(applyToJobRepository repository, PersonRepository personRepository, CompanyRepository companyRepository, CityRepository cityRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Object registerPerson(PersonDTO personDTO) throws IOException {
        if (personDTO.getFullName() == null && personDTO.getFullName() == ""
                || personDTO.getUsername() == null
                || personDTO.getPassword() == null
                || personDTO.getCity() == null
                || personDTO.getCanddescription() == null
                || personDTO.getPhone() == null
                || personDTO.getField() == null
                || personDTO.getEmail() == null
                || personDTO.getDateOfBirth() == null
                || personDTO.getGender() == null

        ) {
            return "One filed is empty";
        }

        if (!personRepository.findByUserName(personDTO.getUsername()).isEmpty()
                && !companyRepository.findByUserName(personDTO.getUsername()).isEmpty()) {
            return "User Name is Used";
        }

        if (!personRepository.findByPersonEmail(personDTO.getEmail()).isEmpty()
                && !companyRepository.findByCompanyEmail(personDTO.getEmail()).isEmpty()) {
            return "Email is Used";
        }

        if (!personRepository.findByPersonPhone(personDTO.getPhone()).isEmpty()) {
            return "Phone Number is Used";
        }

        Person person = new Person();
        person.setFullName(personDTO.getFullName());
        person.setUserName(personDTO.getUsername());
        //person.setCity(cityRepository.findBycity_id(city));
        City city = cityRepository.findByCityName(personDTO.getCity());
        if (city != null) {
            person.setCity(city);
        } else {
            System.out.println(personDTO.getCity() + " is not found ");
            return null;
        }
        person.setPersonEmail(personDTO.getEmail());
        person.setPassword(personDTO.getPassword());
        person.setPersonPhone(personDTO.getPhone());
        person.setPersonField(personDTO.getField());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(personDTO.getDateOfBirth(), format);
        person.setDateOfBirth(localDate);
        person.setGender(personDTO.getGender());
        person.setStudyDegree(personDTO.getStudyDegree());
        person.setDescription(personDTO.getCanddescription());
        person.setInterests(personDTO.getIntrest());

        String cvPath = StringUtils.cleanPath(personDTO.getCvPath().getOriginalFilename());
        person.setCvPath(cvPath);
        String picPath = StringUtils.cleanPath(personDTO.getPicPath().getOriginalFilename());
        person.setCvPath(picPath);

        Person person1 = personRepository.save(person);
        String uploadCV = "./person-cv/" + person1.getPerson_id();
        String uploadPic = "./person-image/" + person1.getPerson_id();
        Path uploadPath = Paths.get(uploadCV);
        Path uploadPath2 = Paths.get(uploadPic);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        if (!Files.exists(uploadPath2)) {
            Files.createDirectories(uploadPath2);
        }

        InputStream CVStream = personDTO.getCvPath().getInputStream();
        InputStream PicStream = personDTO.getPicPath().getInputStream();

        Path CVFilePath = uploadPath.resolve(cvPath);
        Path PicFilePath = uploadPath2.resolve(picPath);
        Files.copy(CVStream,CVFilePath,StandardCopyOption.REPLACE_EXISTING);
        Files.copy(PicStream,PicFilePath,StandardCopyOption.REPLACE_EXISTING);

        return person1;
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
        System.out.println(personDTO.toString());
        Person per = personRepository.findById(personDTO.getPersonID()).orElse(null);
        System.out.println("SDFSDFSDFSDF");
        if (personDTO.getFullName() != null && !personDTO.getFullName().equals("")) {
            per.setFullName(personDTO.getFullName());
        }
        if (personDTO.getUsername() != null && !personDTO.getUsername().equals("")) {
            per.setUserName(personDTO.getUsername());
        }
        if (personDTO.getCity() != null && !personDTO.getCity().equals("")) {
            City city = cityRepository.findByCityName(personDTO.getCity());
            if (city != null) {
                per.setCity(city);
            }
        }
        if (personDTO.getEmail() != null && !personDTO.getEmail().equals("")) {
            per.setPersonEmail(personDTO.getEmail());
        }
        if (personDTO.getPassword() != null && !personDTO.getPassword().equals("")) {
            per.setPassword(personDTO.getPassword());
        }
        if (personDTO.getPhone() != null && !personDTO.getPhone().equals("")) {
            per.setPersonPhone(personDTO.getPhone());
        }
        if (personDTO.getField() != null && !personDTO.getField().equals("")) {
            System.out.println(personDTO.getField());
            per.setPersonField(personDTO.getField());
        }
        if (personDTO.getDateOfBirth() != null && !personDTO.getDateOfBirth().equals("")) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(personDTO.getDateOfBirth(), format);
            per.setDateOfBirth(localDate);
        }
        if (personDTO.getGender() != null && !personDTO.getGender().equals("")) {
            per.setGender(personDTO.getGender());
        }
        if (personDTO.getStudyDegree() != null && !personDTO.getStudyDegree().equals("")) {
            per.setStudyDegree(personDTO.getStudyDegree());
        }
        if (personDTO.getCanddescription() != null && !personDTO.getCanddescription().equals("")) {
            per.setDescription(personDTO.getCanddescription());
        }
        if (personDTO.getIntrest() != null && !personDTO.getIntrest().equals("")) {
            per.setInterests(personDTO.getIntrest());
        }

        personRepository.save(per);
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

    @Override
    public List<ApplicationPerson> ShowApplication(int id) {
        return repository.findByPersonsid(id);
    }

}
