package com.example.BIWorld.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    private Integer companyID ;

    @Column(name = "CompanyName")
    private String CompanyName ;

    @ManyToMany
    @Column(name = "cityId")
    private Set<City> city ;


    @Column(name = "companyDescription")
    private String companyDescription ;

    @Column(name = "CompanyPhone")
    private Double CompanyPhone ;

    @Column(name = "CompanyFax")
    private Long CompanyFax ;

    @Column(name = "CompanyEmail")
    private String CompanyEmail ;

    @Column(name = "CompanyTax")
    private Integer CompanyTax ;

    @Column(name = "address")
    private String address ;

    @OneToMany
    private Set<Jobs> jobs ;

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
        this.companyID = companyID;
        this.CompanyName = companyName;
        this.city = city;
        this.companyDescription = companyDescription;
        this.CompanyPhone = companyPhone;
        this.CompanyFax = companyFax;
        this.CompanyEmail = companyEmail;
        this.CompanyTax = companyTax;
        this.address = address;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Set<City> getCity() {
        return city;
    }

    public void setCity(Set<City> city) {
        this.city = city;
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
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", CompanyName='" + CompanyName + '\'' +
                ", city=" + city +
                ", companyDescription='" + companyDescription + '\'' +
                ", CompanyPhone=" + CompanyPhone +
                ", CompanyFax=" + CompanyFax +
                ", CompanyEmail='" + CompanyEmail + '\'' +
                ", CompanyTax=" + CompanyTax +
                ", address='" + address + '\'' +
                '}';
    }
}
