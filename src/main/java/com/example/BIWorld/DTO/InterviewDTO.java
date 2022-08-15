package com.example.BIWorld.DTO;


import com.example.BIWorld.models.ApplyToJob;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InterviewDTO {
    private ApplyToJob applyToJob;
    private String location;
    private String employeeName;
    private String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime date;
}
