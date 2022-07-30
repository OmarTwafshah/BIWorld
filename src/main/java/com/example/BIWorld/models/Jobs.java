package com.example.BIWorld.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "jobs")
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue
    private Integer job_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
    private City companies ;

    @Column(name = "job_description")
    private String jobDescription ;

    @Column(name = "job_field")
    private String jobField ;

    @Column(name = "job_start_date")
    private LocalDate jobStartDate ;

    @Column(name = "job_end_date")
    private LocalDate jobEndDate ;

    @Column(name = "job_is_finished")
    private Boolean jobIsFinished ;

    @Column(name = "degree_requierd")
    private String degreeRequierd ;

    @Column(name = "gender_to_job")
    private String genderToJob ;

    @Column(name = "job_time")
    private String jobTime ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "jobs_To_application")
    private Set<ApplyToJob> applyToJobs ;

    public Jobs(){}

    public Jobs(Integer job_id,
                City companyID,
                String jobDescription,
                String jobField,
                LocalDate jobStartDate,
                LocalDate jobEndDate,
                Boolean jobIsFinished,
                String degreeRequierd,
                String genderToJob,
                String jobTime) {
        this.job_id = job_id;
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

    public void setJobId(Integer jobId) {
        this.job_id = jobId;
    }

    public City getCompanyID() {
        return companies;
    }

    public void setCompanyID(City companyID) {
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
