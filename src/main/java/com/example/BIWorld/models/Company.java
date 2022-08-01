package com.example.BIWorld.models;


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
    private Integer company_id ;

    @Column(
            name = "company_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String CompanyName ;

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

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "companies")
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
    private Double CompanyPhone ;

    @Column(
            name = "company_fax",
            nullable = false
    )
    private Long CompanyFax ;

    @Column(
            name = "company_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String CompanyEmail ;

    @Column(
            name = "company_tax",
            nullable = false
    )
    private Integer CompanyTax ;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "companies")
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
                   Double companyPhone,
                   Long companyFax,
                   String companyEmail,
                   Integer companyTax,
                   String address) {
        CompanyName = companyName;
        this.companyUserName = companyUserName;
        this.companyPassword = companyPassword;
        this.cities = cities;
        this.companyDescription = companyDescription;
        CompanyPhone = companyPhone;
        CompanyFax = companyFax;
        CompanyEmail = companyEmail;
        CompanyTax = companyTax;
        this.address = address;
    }

    public Integer getCompany_id() {
        return company_id;
    }


    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
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
        return CompanyPhone;
    }

    public void setCompanyPhone(Double companyPhone) {
        CompanyPhone = companyPhone;
    }

    public Long getCompanyFax() {
        return CompanyFax;
    }

    public void setCompanyFax(Long companyFax) {
        CompanyFax = companyFax;
    }

    public String getCompanyEmail() {
        return CompanyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        CompanyEmail = companyEmail;
    }

    public Integer getCompanyTax() {
        return CompanyTax;
    }

    public void setCompanyTax(Integer companyTax) {
        CompanyTax = companyTax;
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
        return Objects.equals(company_id, company.company_id) &&
                Objects.equals(CompanyName, company.CompanyName) &&
                Objects.equals(companyUserName, company.companyUserName) &&
                Objects.equals(companyPassword, company.companyPassword) &&
                Objects.equals(cities, company.cities) &&
                Objects.equals(companyDescription, company.companyDescription) &&
                Objects.equals(CompanyPhone, company.CompanyPhone) &&
                Objects.equals(CompanyFax, company.CompanyFax) &&
                Objects.equals(CompanyEmail, company.CompanyEmail) &&
                Objects.equals(CompanyTax, company.CompanyTax) &&
                Objects.equals(address, company.address) &&
                Objects.equals(jobs, company.jobs) &&
                Objects.equals(applyToJobs, company.applyToJobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company_id, CompanyName, companyUserName, companyPassword, cities, companyDescription, CompanyPhone, CompanyFax, CompanyEmail, CompanyTax, address, jobs, applyToJobs);
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", CompanyName='" + CompanyName + '\'' +
                ", companyUserName='" + companyUserName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", CompanyPhone=" + CompanyPhone +
                ", CompanyFax=" + CompanyFax +
                ", CompanyEmail='" + CompanyEmail + '\'' +
                ", CompanyTax=" + CompanyTax +
                ", address='" + address + '\'' +
                '}';
    }
}