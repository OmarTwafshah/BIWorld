package com.example.BIWorld.DTO;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class ApplyToJobDTO {
    private Set<Person> myPersons;
    private Company company;
    private Jobs jobsToApplication;
    private String status;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfApplication;

}
