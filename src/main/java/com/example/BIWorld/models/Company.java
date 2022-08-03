package com.example.BIWorld.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {

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
            name = "company_id",
            updatable = false
    )
    private Integer companyID ;

    @Column(
            name = "company_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyName ;

    @Column(
            name = "company_user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyUserName ;

    @Column(
            name = "company_password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyPassword ;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "companies")
    @JsonIgnoreProperties(value = "companies")
    private Set<City> cities ;

    @Column(
            name = "company_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyDescription ;

    @Column(
            name = "company_phone",
            nullable = false
    )
    private Double companyPhone ;

    @Column(
            name = "company_fax",
            nullable = false
    )
    private Long companyFax ;

    @Column(
            name = "company_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyEmail ;

    @Column(
            name = "company_tax",
            nullable = false
    )
    private Integer companyTax ;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "companyID")
    private Set<Jobs> jobs ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "company")
    private Set<ApplyToJob> applyToJobs ;



    public Company() {

    }

    public Company(String companyName,
                   String companyUserName,
                   String companyPassword,
                   Set<City> cities,
                   String companyDescription,
                   Double CompanyPhone,
                   Long companyFax,
                   String companyEmail,
                   Integer companyTax,
                   String address) {
        this.companyName = companyName;
        this.companyUserName = companyUserName;
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
        return companyUserName;
    }

    public void setCompanyUserName(String companyUserName) {
        this.companyUserName = companyUserName;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyID, company.companyID) &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(companyUserName, company.companyUserName) &&
                Objects.equals(companyPassword, company.companyPassword) &&
                Objects.equals(cities, company.cities) &&
                Objects.equals(companyDescription, company.companyDescription) &&
                Objects.equals(companyPhone, company.companyPhone) &&
                Objects.equals(companyFax, company.companyFax) &&
                Objects.equals(companyEmail, company.companyEmail) &&
                Objects.equals(companyTax, company.companyTax) &&
                Objects.equals(address, company.address) &&
                Objects.equals(jobs, company.jobs) &&
                Objects.equals(applyToJobs, company.applyToJobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyID, companyName, companyUserName, companyPassword, cities, companyDescription, companyPhone, companyFax, companyEmail, companyTax, address, jobs, applyToJobs);
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + companyID +
                ", CompanyName='" + companyName + '\'' +
                ", City ='" + cities + '\'' +
                ", companyUserName='" + companyUserName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", CompanyPhone=" + companyPhone +
                ", CompanyFax=" + companyFax +
                ", CompanyEmail='" + companyEmail + '\'' +
                ", CompanyTax=" + companyTax +
                ", address='" + address + '\'' +
                '}';
    }
}