package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Jobs {

    @Id
    @GeneratedValue
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name="companyID")
    private City companyID ;

    @Column(name = "jobDescription")
    private String jobDescription ;

    @Column(name = "jobField")
    private String jobField ;

    @Column(name = "jobStartDate")
    private LocalDate jobStartDate ;

    @Column(name = "jobEndDate")
    private LocalDate jobEndDate ;

    @Column(name = "jobIsFinished")
    private Boolean jobIsFinished ;

    @Column(name = "degreeRequierd")
    private String degreeRequierd ;

    @Column(name = "genderToJob")
    private String genderToJob ;

    @Column(name = "jobTime")
    private String jobTime ;

    public Jobs(){}

    public Jobs(Integer jobId,
                City companyID,
                String jobDescription,
                String jobField,
                LocalDate jobStartDate,
                LocalDate jobEndDate,
                Boolean jobIsFinished,
                String degreeRequierd,
                String genderToJob,
                String jobTime) {
        this.jobId = jobId;
        this.companyID = companyID;
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
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public City getCompanyID() {
        return companyID;
    }

    public void setCompanyID(City companyID) {
        this.companyID = companyID;
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
                "jobId=" + jobId +
                ", companyID=" + companyID +
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
