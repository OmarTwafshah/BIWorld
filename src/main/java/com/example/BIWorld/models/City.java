package com.example.BIWorld.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "cities")
@Table(name = "cities")
public class City implements Serializable {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    @Column(
            name = "city_id",
            updatable = false
    )
    private Integer city_id;
    @Column(
            name = "city_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String cityName;

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "city_company",
            joinColumns = { @JoinColumn(name = "city_id" , nullable = true) },
            inverseJoinColumns = { @JoinColumn(name = "company_id") }
    )
    @JsonIgnoreProperties(value = "cities")
    private Set<Company> companies ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "cities")
    private Set<Person> persons ;

    public City(){}

    public City(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityId=" + city_id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}