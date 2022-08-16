package com.example.BIWorld.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "apply_to_job")
@Table(name = "apply_to_job")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplyToJob implements Serializable {
    public void setApplication_id(Integer application_id) {
        this.application_id = application_id;
    }

    @Id
    @SequenceGenerator(
            name = "apply_to_job_sequence",
            sequenceName = "apply_to_job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "apply_to_job_sequence"
    )
    @Column(
            name = "application_id",
            updatable = false
    )
    private Integer application_id;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person myPersons;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "job_id")
    private Jobs jobsToApplication;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String status;

    @Column(
            name = "date_of_application",
            nullable = false
    )
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfApplication;

    @OneToOne(mappedBy = "applyToJob")
    @JsonIgnoreProperties(value = "applyToJob")
    private Interview interview;

    public ApplyToJob() {

    }

    public ApplyToJob(
            Person persons,
            Company company,
            Jobs jobs_To_application,
            LocalDate date_of_application,
            String status) {
        this.myPersons = persons;
        this.company = company;
        this.jobsToApplication = jobs_To_application;
        this.dateOfApplication = date_of_application;
        this.status = status;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public Person getPersons() {
        return myPersons;
    }

    public void setPersons(Person persons) {
        this.myPersons = persons;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Jobs getJobs_To_application() {
        return jobsToApplication;
    }

    public void setJobs_To_application(Jobs jobs_To_application) {
        this.jobsToApplication = jobs_To_application;
    }

    public LocalDate getDate_of_application() {
        return dateOfApplication;
    }

    public void setDate_of_application(LocalDate date_of_application) {
        this.dateOfApplication = date_of_application;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplyToJob{" +
                "application_id=" + application_id +
                ", persons=" + myPersons +
                ", company=" + company +
                ", jobs_To_application=" + jobsToApplication +
                ", date_of_application=" + dateOfApplication +
                ", status='" + status + '\'' +
                '}';
    }
}