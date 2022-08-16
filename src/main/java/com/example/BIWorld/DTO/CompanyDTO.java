package com.example.BIWorld.DTO;


import com.example.BIWorld.models.City;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Setter
@Getter
public class CompanyDTO {
    private Integer companyID;
    private String companyName;
    private String username;
    private String password;
    private String city;
    private String compdescription;
    private Double phone;
    private Long fax;
    private String email;
    private Integer tax;
    private String address;

}
