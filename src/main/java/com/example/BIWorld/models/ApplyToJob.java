package com.example.BIWorld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ApplyToJob {

    @Id
    @GeneratedValue
    private Integer applicationId;


}
