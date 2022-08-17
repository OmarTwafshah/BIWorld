package com.example.BIWorld.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "cities")
@Table(name = "cities")
@Data
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

    public String getCityName() {
        return cityName;
    }

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

    @OneToMany(mappedBy = "cities")
    @JsonIgnore
    private Set<Company> companies ;

    @OneToMany(mappedBy = "cities")
    @JsonIgnore
    private Set<Person> persons ;


}