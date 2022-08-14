package com.example.BIWorld.DTO;


import com.example.BIWorld.models.City;
import lombok.Data;

import java.util.Set;

@Data
public class CompanyDTO {
    private String companyName;
    private String companyUserName;
    private String companyPassword;
    private Set<City> cities;
    private String companyDescription;
    private Double companyPhone;
    private Long companyFax;
    private String companyEmail;
    private Integer companyTax;
    private String address;

}
