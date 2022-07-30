package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "apply_to_job")
@Table(name = "apply_to_job")
public class ApplyToJob {
    @Id
    @GeneratedValue
    private Integer application_id;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "applyToJobs")
    private Set<Person> persons ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
    private Company company ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    private Jobs jobs_To_application ;

    @Column(name="date_of_application")
    private LocalDate date_of_application;

    @Column(name="status")
    private String status;

    @OneToOne(mappedBy = "applyToJob")
    private Interview interview ;

    public ApplyToJob() {

    }

    public ApplyToJob(Integer application_id,
                      Set<Person> persons,
                      Company company,
                      Jobs jobs_To_application,
                      LocalDate date_of_application,
                      String status) {
        this.application_id = application_id;
        this.persons = persons;
        this.company = company;
        this.jobs_To_application = jobs_To_application;
        this.date_of_application = date_of_application;
        this.status = status;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Integer application_id) {
        this.application_id = application_id;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Jobs getJobs_To_application() {
        return jobs_To_application;
    }

    public void setJobs_To_application(Jobs jobs_To_application) {
        this.jobs_To_application = jobs_To_application;
    }

    public LocalDate getDate_of_application() {
        return date_of_application;
    }

    public void setDate_of_application(LocalDate date_of_application) {
        this.date_of_application = date_of_application;
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
                ", jobs_To_application=" + jobs_To_application +
                ", date_of_application=" + date_of_application +
                ", status='" + status + '\'' +
                '}';
    }
}
