package com.example.BIWorld.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplyToJobInfo {
    private Integer personID ;
    private String personName ;
    private String personEmail ;
    private String StudyDegree;
    private Integer ApplicationID ;
    private LocalDate Date ;
    private String status ;


    public ApplyToJobInfo(Integer personID, String personName, String personEmail, String studyDegree, Integer applicationID, LocalDate date, String status) {
        this.personID = personID;
        this.personName = personName;
        this.personEmail = personEmail;
        StudyDegree = studyDegree;
        ApplicationID = applicationID;
        Date = date;
        this.status = status;
    }
}
