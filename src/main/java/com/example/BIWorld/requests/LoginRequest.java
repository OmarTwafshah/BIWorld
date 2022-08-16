package com.example.BIWorld.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class LoginRequest {
    private String userName;
    private String myPassword;
}
