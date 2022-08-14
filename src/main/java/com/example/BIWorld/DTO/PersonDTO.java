package com.example.BIWorld.DTO;


import com.example.BIWorld.models.City;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class PersonDTO {
    private String fullName;
    private String userName;
    private City cities;
    private String personEmail;
    private String password;
    private Double personPhone;
    private String personField;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String gender;
    private String studyDegree;
    private String description;
    private String picPath;
    private String interests;


}
