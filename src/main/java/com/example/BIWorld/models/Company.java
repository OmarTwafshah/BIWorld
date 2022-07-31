package com.example.BIWorld.models;


import javax.persistence.*;
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

    public Company(
                   String companyName,
                   Set<City> city,
                   String companyDescription,
                   Double companyPhone,
                   Long companyFax,
                   String companyEmail,
                   Integer companyTax,
                   String address) {
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