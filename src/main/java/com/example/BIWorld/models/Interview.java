package com.example.BIWorld.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "interview")
@Table(name = "interview")
public class Interview {
    @Id
    @SequenceGenerator(
            name = "interview_sequence",
            sequenceName = "interview_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "interview_sequence"
    )
    @Column(
            name = "interview_id",
            updatable = false
    )
    private Integer interview_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_information")
    @JsonIgnoreProperties(value = "interview")
    private ApplyToJob applyToJob;

    @Column(
            name = "location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String location;

    @Column(
            name = "employee_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String employeeName;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "date",
            nullable = false
    )
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Interview(){}

    public Interview(
                     ApplyToJob applyToJob,
                     LocalDate date,
                     String location,
                     String employee_name,
                     String description) {
        this.applyToJob = applyToJob;
        this.date = date;
        this.location = location;
        this.employeeName = employee_name;
        this.description = description;
    }

    public Integer getInterview_id() {
        return interview_id;
    }

    public ApplyToJob getApplyToJob() {
        return applyToJob;
    }

    public void setApplyToJob(ApplyToJob applyToJob) {
        this.applyToJob = applyToJob;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployee_name() {
        return employeeName;
    }

    public void setEmployee_name(String employee_name) {
        this.employeeName = employee_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interview_id=" + interview_id +
                ", applyToJob=" + applyToJob +
                ", date=" + date +
                ", location=" + location +
                ", employee_name=" + employeeName +
                ", description=" + description +
                '}';
    }
}
