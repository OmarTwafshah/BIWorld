package com.example.BIWorld.Service;



import com.example.BIWorld.DTO.PersonDTO;
import com.example.BIWorld.Repository.CityRepository;
import com.example.BIWorld.Repository.CompanyRepository;
import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.City;
import com.example.BIWorld.models.Person;
import com.example.BIWorld.requests.ApplicationPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.apache.tomcat.util.http.fileupload.FileUploadBase.CONTENT_DISPOSITION;

@Service
public class PersonServiceImp implements PersonService {

    private final applyToJobRepository repository;

    private final PersonRepository personRepository;

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;

    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

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
        System.out.println(cvPath);
        String picPath = StringUtils.cleanPath(personDTO.getPicPath().getOriginalFilename());
        person.setPicPath(picPath);
        System.out.println(picPath);


        Person person1 = personRepository.save(person);
        String uploadCV = "./person-cv/" + person1.getPerson_id();
        String uploadPic = "./person-image/" + person1.getPerson_id();
        Path uploadPath = get(uploadCV);
        Path uploadPath2 = get(uploadPic);
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
    public Person getJustPerson(int id){
        return personRepository.findByPerson_id(id);
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

    @Override
    public ResponseEntity<Resource> getimage(int id) throws Exception {
        Person person = personRepository.findByPerson_id(id);
        Path filePath = get("./person-image/"+person.getPersonID()+"/").toAbsolutePath().normalize().resolve(String.valueOf(person.getPicPath()));

        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(person.getPerson_id() + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name",person.getPicPath() );
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }

    @Override
    public ResponseEntity<Resource> getCV(int id) throws Exception {
        Person person = personRepository.findByPerson_id(id);
        Path filePath = get("./person-cv/"+person.getPersonID()+"/").toAbsolutePath().normalize().resolve(String.valueOf(person.getCvPath()));

        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(person.getPerson_id() + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name",person.getPicPath() );
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }

}
