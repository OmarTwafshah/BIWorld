package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private long personID;

    @Column(name = "FullName")
    private String FullName ;

    @Column(name = "UserName")
    private String UserName ;

    @ManyToOne
    @JoinColumn(name="cityId")
    private City city ;

    @Column(name = "personEmail")
    private String PersonEmail ;

    @Column(name = "password")
    private String password ;

    @Column(name = "personPhone")
    private Double personPhone ;

    @Column(name = "personField")
    private String personField ;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth ;

    @Column(name = "gender")
    private String gender ;

    @Column(name = "studyDegree")
    private String studyDegree ;

    @Column(name = "description")
    private String description ;

    @Column(name = "picPath")
    private String picPath ;

    @Column(name = "haveCV")
    private boolean haveCV ;

    public Person(){}

    public Person(long personID,
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
        this.personID = personID;
        FullName = fullName;
        UserName = userName;
        this.city = city;
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

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
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
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", FullName='" + FullName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", city=" + city +
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
