package com.example.BIWorld.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "apply_to_job")
@Table(name = "apply_to_job")
public class ApplyToJob implements Serializable {
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

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "applyToJobs")
    private Set<Person> persons ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
    private Company company ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    private Jobs jobsToApplication ;

    @Column(
            name="date_of_application",
            nullable = false
    )
    private LocalDate dateOfApplication;

    @Column(
            name="status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String status;

    @OneToOne(mappedBy = "applyToJob")
    @JsonIgnoreProperties(value = "applyToJob")
    private Interview interview ;

    public ApplyToJob() {

    }

    public ApplyToJob(
                      Set<Person> persons,
                      Company company,
                      Jobs jobs_To_application,
                      LocalDate date_of_application,
                      String status) {
        this.persons = persons;
        this.company = company;
        this.jobsToApplication = jobs_To_application;
        this.dateOfApplication = date_of_application;
        this.status = status;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
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
                ", persons=" + persons +
                ", company=" + company +
                ", jobs_To_application=" + jobsToApplication +
                ", date_of_application=" + dateOfApplication +
                ", status='" + status + '\'' +
                '}';
    }
}