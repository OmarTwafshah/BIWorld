package com.example.BIWorld.models;


import javax.persistence.*;

@Entity(name = "interview")
@Table(name = "interview")
public class Interview {
    @Id
    @GeneratedValue
    private Integer interview_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_information")
    private ApplyToJob applyToJob;


}
