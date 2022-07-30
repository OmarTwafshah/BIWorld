package com.example.BIWorld.models;

import jdk.jfr.Relational;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cities")
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue
    private Integer city_id;
    @Column(name = "city_name")
    private String cityName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "city_company",
            joinColumns = { @JoinColumn(name = "city_id") },
            inverseJoinColumns = { @JoinColumn(name = "company_id") }
    )
    private Set<Company> companies ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "cities")
    private Set<Person> persons ;

    public City(){}

    public City(Integer cityId, String cityName) {
        this.city_id = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return city_id;
    }

    public void setCityId(Integer cityId) {
        this.city_id = cityId;
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
