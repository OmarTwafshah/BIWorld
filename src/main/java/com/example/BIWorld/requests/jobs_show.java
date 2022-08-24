package com.example.BIWorld.requests;

import lombok.Data;

@Data
public class jobs_show {
    private Integer jobId ;
    private String jobField ;
    private String jobTitle;
    private String companyName ;
    private String cityName ;
}
