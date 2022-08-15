package com.example.BIWorld.DTO;


import com.example.BIWorld.models.City;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonDTO {
    private Integer person_id;
    private String fullName;
    private String userName;
    private City cities;
    private String personEmail;
    private String password;
    private Double personPhone;
    private String personField;
    @NotNull
    private String dateOfBirth;
    private String gender;
    private String studyDegree;
    private String description;
    private String picPath;
    private String interests;

    public PersonDTO(){}

}
