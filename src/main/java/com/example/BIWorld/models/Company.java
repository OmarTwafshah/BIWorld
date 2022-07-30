package com.example.BIWorld.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    private Integer company_id ;

    @Column(name = "company_name")
    private String CompanyName ;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "companies")
    private Set<City> cities ;

    @Column(name = "company_description")
    private String companyDescription ;

    @Column(name = "company_phone")
    private Double CompanyPhone ;

    @Column(name = "company_fax")
    private Long CompanyFax ;

    @Column(name = "company_email")
    private String CompanyEmail ;

    @Column(name = "company_tax")
    private Integer CompanyTax ;

    @Column(name = "address")
    private String address ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "companies")
    private Set<Jobs> jobs ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "company")
    private Set<ApplyToJob> applyToJobs ;



    public Company() {

    }

    public Company(Integer companyID,
                   String companyName,
                   Set<City> city,
                   String companyDescription,
                   Double companyPhone,
                   Long companyFax,
                   String companyEmail,
                   Integer companyTax,
                   String address) {
        this.company_id = companyID;
        this.CompanyName = companyName;
//        this.city = city;
        this.companyDescription = companyDescription;
        this.CompanyPhone = companyPhone;
        this.CompanyFax = companyFax;
        this.CompanyEmail = companyEmail;
        this.CompanyTax = companyTax;
        this.address = address;
    }

    public Integer getCompanyID() {
        return company_id;
    }

    public void setCompanyID(Integer companyID) {
        this.company_id = companyID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

//    public Set<City> getCity() {
//        return city;
//    }

//    public void setCity(Set<City> city) {
//        this.city = city;
//    }

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
    public String toString() {
        return "Company{" +
                "companyID=" + company_id +
                ", CompanyName='" + CompanyName + '\'' +
//                ", city=" + city +
                ", companyDescription='" + companyDescription + '\'' +
                ", CompanyPhone=" + CompanyPhone +
                ", CompanyFax=" + CompanyFax +
                ", CompanyEmail='" + CompanyEmail + '\'' +
                ", CompanyTax=" + CompanyTax +
                ", address='" + address + '\'' +
                '}';
    }
}
