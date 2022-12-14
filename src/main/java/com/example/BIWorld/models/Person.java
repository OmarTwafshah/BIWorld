package com.example.BIWorld.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity(name = "persons")
@Table(name = "persons")
public class Person {
    @Id
    @SequenceGenerator(
            name = "persons_sequence",
            sequenceName = "persons_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "persons_sequence"
    )
    @Column(
            name = "person_id",
            updatable = false
    )
    private Integer person_id;

    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName ;

    @Column(
            name = "user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userName ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City cities ;

    @Column(
            name = "person_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String personEmail ;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password ;

    @Column(
            name = "person_phone",
            nullable = false
    )
    private Double personPhone ;

    @Column(
            name = "person_field",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String personField ;

    @Column(
            name = "date_of_birth",
            nullable = false
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth ;

    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String gender ;

    @Column(
            name = "study_degree",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String studyDegree ;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description ;

    @Column(
            name = "pic_path",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String picPath ;

    @Column(
            name = "have_cv",
            nullable = false
    )
    private Boolean haveCV ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "applyToJob_Person",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "application_id") }
    )
    private Set<ApplyToJob> applyToJobs ;

    public Person(){}

    public Person(
                  String fullName,
                  String user_name,
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
        this.fullName = fullName;
        this.userName = user_name;
        this.cities = city;
        this.personEmail = personEmail;
        this.password = password;
        this.personPhone = personPhone;
        this.personField = personField;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.studyDegree = studyDegree;
        this.description = description;
        this.picPath = picPath;
        this.haveCV = haveCV;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getPersonID() {
        return person_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String UserName) {
        userName = UserName;
    }

    public City getCity() {
        return cities;
    }

    public void setCity(City city) {
        this.cities = city;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(Double personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonField() {
        return personField;
    }

    public void setPersonField(String personField) {
        this.personField = personField;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudyDegree() {
        return studyDegree;
    }

    public void setStudyDegree(String studyDegree) {
        this.studyDegree = studyDegree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public boolean isHaveCV() {
        return haveCV;
    }

    public void setHaveCV(boolean haveCV) {
        this.haveCV = haveCV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(person_id, person.person_id) &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(userName, person.userName) &&
                Objects.equals(cities, person.cities) &&
                Objects.equals(personEmail, person.personEmail) &&
                Objects.equals(password, person.password) &&
                Objects.equals(personPhone, person.personPhone) &&
                Objects.equals(personField, person.personField) &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(studyDegree, person.studyDegree) &&
                Objects.equals(description, person.description) &&
                Objects.equals(picPath, person.picPath) &&
                Objects.equals(haveCV, person.haveCV) &&
                Objects.equals(applyToJobs, person.applyToJobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, fullName, userName, cities, personEmail, password, personPhone, personField, dateOfBirth, gender, studyDegree, description, picPath, haveCV, applyToJobs);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + person_id +
                ", FullName='" + fullName + '\'' +
                ", UserName='" + userName + '\'' +
                ", cities=" + cities +
                ", PersonEmail='" + personEmail + '\'' +
                ", personPhone=" + personPhone +
                ", personField='" + personField + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", studyDegree='" + studyDegree + '\'' +
                ", description='" + description + '\'' +
                ", picPath='" + picPath + '\'' +
                ", haveCV=" + haveCV +
                '}';
    }
}