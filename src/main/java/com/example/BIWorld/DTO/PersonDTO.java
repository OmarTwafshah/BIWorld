package com.example.BIWorld.DTO;


import com.example.BIWorld.models.City;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class PersonDTO {
    private Integer personID;
    private String fullName;
    private String username;
    private String city;
    private String email;
    private String password;
    private Double phone;
    private String field;
    @NotNull
    private String dateOfBirth;
    private String gender;
    private String studyDegree;
    private String canddescription;
    private String picPath;
    private String intrest;

    public PersonDTO(){}

}
