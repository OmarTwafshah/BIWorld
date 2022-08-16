package com.example.BIWorld.DTO;

import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Setter
@Getter
public class ApplyToJobDTO {
    private String persons;
    private String job;

}
