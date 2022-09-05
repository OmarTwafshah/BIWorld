package com.example.BIWorld.requests;

import lombok.Data;

@Data
public class FilterJobs {
    private Integer personID;
    private String personField ;
    private String studyDegree;
    private String gender ;
    private String city ;

}
