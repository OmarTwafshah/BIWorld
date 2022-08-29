package com.example.BIWorld.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    @Column(
            name = "company_id"
    )
    @JsonIgnore
    private Integer companyID;

    @Column(
            name = "company_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyName;

    @Column(
            name = "company_user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userName;

    @Column(
            name = "company_password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @JsonIgnore
    private String companyPassword;

    private String type = "company";

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City cities;

    @Column(
            name = "company_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyDescription;

    @Column(
            name = "company_phone",
            nullable = false
    )
    private Double companyPhone;

    @Column(
            name = "company_fax",
            nullable = false
    )
    private Long companyFax;

    @Column(
            name = "company_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyEmail;

    @Column(
            name = "company_tax",
            nullable = false
    )
    private Integer companyTax;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    public Set<Jobs> getJobs() {
        return jobs;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "companyID")
    private Set<Jobs> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<ApplyToJob> applyToJobs;


    public Company() {

    }

    public Company(String companyName,
                   String companyUserName,
                   String companyPassword,
                   City cities,
                   String companyDescription,
                   Double CompanyPhone,
                   Long companyFax,
                   String companyEmail,
                   Integer companyTax,
                   String address) {
        this.companyName = companyName;
        this.userName = companyUserName;
        this.companyPassword = companyPassword;
        this.cities = cities;
        this.companyDescription = companyDescription;
        this.companyPhone = CompanyPhone;
        this.companyFax = companyFax;
        this.companyEmail = companyEmail;
        this.companyTax = companyTax;
        this.address = address;
    }

    public Integer getCompany_id() {
        return companyID;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUserName() {
        return userName;
    }

    public void setCompanyUserName(String companyUserName) {
        this.userName = companyUserName;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public City getCities() {
        return cities;
    }

    public void setCities(City cities) {
        this.cities = cities;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Double getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(Double companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Long getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(Long companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public Integer getCompanyTax() {
        return companyTax;
    }

    public void setCompanyTax(Integer companyTax) {
        this.companyTax = companyTax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setJobs(Set<Jobs> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + companyID +
                ", CompanyName='" + companyName + '\'' +
                ", City ='" + cities + '\'' +
                ", userName='" + userName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", CompanyPhone=" + companyPhone +
                ", CompanyFax=" + companyFax +
                ", CompanyEmail='" + companyEmail + '\'' +
                ", CompanyTax=" + companyTax +
                ", address='" + address + '\'' +
                '}';
    }
}