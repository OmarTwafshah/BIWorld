package com.example.BIWorld.requests;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationPerson {
    private Integer personId ;
    private Integer jobId ;
    private String companyName ;
    private String jobFiled ;
    private String jobTitle ;
    private LocalDate date;

    private String status ;

    public ApplicationPerson(Integer personId, Integer jobId, String companyName, String jobFiled, String jobTitle, LocalDate date , String Status) {
        this.personId = personId;
        this.jobId = jobId;
        this.companyName = companyName;
        this.jobFiled = jobFiled;
        this.jobTitle = jobTitle;
        this.date = date;
        this.status = Status ;
    }
}
