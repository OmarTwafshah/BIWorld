package com.example.BIWorld.DTO;


import com.example.BIWorld.models.ApplyToJob;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class InterviewDTO {
    private ApplyToJob applyToJob;
    private String location;
    private String employeeName;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
