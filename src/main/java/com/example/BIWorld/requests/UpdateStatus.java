package com.example.BIWorld.requests;

import lombok.Data;

@Data
public class UpdateStatus {
    private Integer jobID ;
    private Integer personID ;
    private String status ;

}
