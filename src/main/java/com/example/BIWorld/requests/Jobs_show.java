package com.example.BIWorld.requests;

import lombok.Data;

@Data
public class Jobs_show {
    private Integer jobId ;
    private String jobTitle;
    private String jobField ;
    private String companyName ;
    private String cityName ;

    public Jobs_show(Integer jobId, String jobTitle, String jobField, String companyName, String cityName) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobField = jobField;
        this.companyName = companyName;
        this.cityName = cityName;
    }
}
