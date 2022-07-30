package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "persons")
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    private Integer person_id;

    @Column(name = "full_name")
    private String FullName ;

    @Column(name = "user_name")
    private String UserName ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City cities ;

    @Column(name = "person_email")
    private String PersonEmail ;

    @Column(name = "password")
    private String password ;

    @Column(name = "person_phone")
    private Double personPhone ;

    @Column(name = "person_field")
    private String personField ;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth ;

    @Column(name = "gender")
    private String gender ;

    @Column(name = "study_degree")
    private String studyDegree ;

    @Column(name = "description")
    private String description ;

    @Column(name = "pic_path")
    private String picPath ;

    @Column(name = "have_cv")
    private Boolean haveCV ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "applyToJob_Person",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "application_id") }
    )
    private Set<ApplyToJob> applyToJobs ;

    public Person(){}

    public Person(Integer personID,
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
        this.person_id = personID;
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

    public void setPersonID(Integer personID) {
        this.person_id = personID;
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

//    public City getCity() {
//        return city;
//    }

//    public void setCity(City city) {
//        this.city = city;
//    }

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
    public String toString() {
        return "Person{" +
                "personID=" + person_id +
                ", FullName='" + FullName + '\'' +
                ", UserName='" + UserName + '\'' +
//                ", city=" + city +
                ", PersonEmail='" + PersonEmail + '\'' +
                ", password='" + password + '\'' +
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
