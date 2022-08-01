package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "jobs")
@Table(name = "jobs")
public class Jobs {

    @Id
    @SequenceGenerator(
            name = "jobs_sequence",
            sequenceName = "jobs_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "jobs_sequence"
    )
    @Column(
            name = "job_id",
            updatable = false
    )
    private Integer job_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
    private Company companies ;

    @Column(
            name = "job_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String jobDescription ;

    @Column(
            name = "job_field",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String jobField ;

    @Column(
            name = "job_start_date",
            nullable = false

    )
    private LocalDate jobStartDate ;

    @Column(
            name = "job_end_date",
            nullable = false
    )
    private LocalDate jobEndDate ;

    @Column(
            name = "job_is_finished",
            nullable = false
    )
    private Boolean jobIsFinished ;

    @Column(
            name = "degree_requierd",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String degreeRequierd ;

    @Column(
            name = "gender_to_job",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String genderToJob ;

    @Column(
            name = "job_time",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String jobTime ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "jobsToApplication")
    private Set<ApplyToJob> applyToJobs ;

    public Jobs(){}

    public Jobs(
                Company companyID,
                String jobDescription,
                String jobField,
                LocalDate jobStartDate,
                LocalDate jobEndDate,
                Boolean jobIsFinished,
                String degreeRequierd,
                String genderToJob,
                String jobTime) {
        this.companies = companyID;
        this.jobDescription = jobDescription;
        this.jobField = jobField;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.jobIsFinished = jobIsFinished;
        this.degreeRequierd = degreeRequierd;
        this.genderToJob = genderToJob;
        this.jobTime = jobTime;
    }

    public Integer getJobId() {
        return job_id;
    }

    public Company getCompanyID() {
        return companies;
    }

    public void setCompanyID(Company companyID) {
        this.companies = companyID;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobField() {
        return jobField;
    }

    public void setJobField(String jobField) {
        this.jobField = jobField;
    }

    public LocalDate getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(LocalDate jobStartDate) {
        this.jobStartDate = jobStartDate;
    }

    public LocalDate getJobEndDate() {
        return jobEndDate;
    }

    public void setJobEndDate(LocalDate jobEndDate) {
        this.jobEndDate = jobEndDate;
    }

    public Boolean getJobIsFinished() {
        return jobIsFinished;
    }

    public void setJobIsFinished(Boolean jobIsFinished) {
        this.jobIsFinished = jobIsFinished;
    }

    public String getDegreeRequierd() {
        return degreeRequierd;
    }

    public void setDegreeRequierd(String degreeRequierd) {
        this.degreeRequierd = degreeRequierd;
    }

    public String getGenderToJob() {
        return genderToJob;
    }

    public void setGenderToJob(String genderToJob) {
        this.genderToJob = genderToJob;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "jobId=" + job_id +
                ", companyID=" + companies +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobField='" + jobField + '\'' +
                ", jobStartDate=" + jobStartDate +
                ", jobEndDate=" + jobEndDate +
                ", jobIsFinished=" + jobIsFinished +
                ", degreeRequierd='" + degreeRequierd + '\'' +
                ", genderToJob='" + genderToJob + '\'' +
                ", jobTime='" + jobTime + '\'' +
                '}';
    }
}