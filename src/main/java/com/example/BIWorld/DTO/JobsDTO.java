package com.example.BIWorld.DTO;


import com.example.BIWorld.models.Company;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class JobsDTO {
    private Company companyID;
    private String jobDescription;
    private String jobField;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate jobStartDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate jobEndDate;
    private Boolean jobIsFinished;
    private String degreeRequierd;
    private String genderToJob;
    private String jobTime;

}
