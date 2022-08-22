package com.example.BIWorld.DTO;


import com.example.BIWorld.models.Company;
import lombok.Data;

@Data
public class JobsDTO {
    private Integer jobId;
    private String jobTitle;
    private String companyID;
    private String jobDescription;
    private String jobField;
    private String jobStartDate;
    private String endDate;
    private Boolean jobIsFinished;
    private String studyDegree;
    private String gender;
    private String jobTime;

}
