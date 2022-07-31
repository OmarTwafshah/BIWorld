package com.example.BIWorld.models;

import jdk.jfr.Relational;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cities")
@Table(name = "cities")
public class City {
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

    public City(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return city_id;
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