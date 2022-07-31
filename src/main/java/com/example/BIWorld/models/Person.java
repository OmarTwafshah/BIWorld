package com.example.BIWorld.models;

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
    private String FullName ;

    @Column(
            name = "user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String UserName ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City cities ;

    @Column(
            name = "person_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String PersonEmail ;

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
        FullName = fullName;
        UserName = userName;
//        this.city = city;
        PersonEmail = personEmail;
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

    public Integer getPersonID() {
        return person_id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public City getCity() {
        return cities;
    }

    public void setCity(City city) {
        this.cities = city;
    }

    public String getPersonEmail() {
        return PersonEmail;
    }

    public void setPersonEmail(String personEmail) {
        PersonEmail = personEmail;
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
                Objects.equals(FullName, person.FullName) &&
                Objects.equals(UserName, person.UserName) &&
                Objects.equals(cities, person.cities) &&
                Objects.equals(PersonEmail, person.PersonEmail) &&
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
        return Objects.hash(person_id, FullName, UserName, cities, PersonEmail, password, personPhone, personField, dateOfBirth, gender, studyDegree, description, picPath, haveCV, applyToJobs);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + person_id +
                ", FullName='" + FullName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", cities=" + cities +
                ", PersonEmail='" + PersonEmail + '\'' +
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