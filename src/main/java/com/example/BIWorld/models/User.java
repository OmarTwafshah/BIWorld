package com.example.BIWorld.models;


import lombok.Data;

import javax.persistence.*;

@Table(name = "users")
@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private int age ;

}
