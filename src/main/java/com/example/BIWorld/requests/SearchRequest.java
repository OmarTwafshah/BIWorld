package com.example.BIWorld.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SearchRequest {
    private String gender ;
    private String city ;
    private String personField ;
    private String studyDegree;

}
