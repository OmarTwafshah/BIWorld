package com.example.BIWorld.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private Long id;
    @JsonIgnoreProperties
    private String name;
    private int age;
}
