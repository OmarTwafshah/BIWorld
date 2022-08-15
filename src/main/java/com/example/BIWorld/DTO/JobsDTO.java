package com.example.BIWorld.DTO;


import com.example.BIWorld.models.Company;
import lombok.Data;

@Data
public class JobsDTO {
    private Integer jobId;
    private Company jobCompany;
    private String jobDescription;
    private String jobField;
    private String jobStartDate;
    private String jobEndDate;
    private Boolean jobIsFinished;
    private String degreeRequierd;
    private String genderToJob;
    private String jobTime;

}
