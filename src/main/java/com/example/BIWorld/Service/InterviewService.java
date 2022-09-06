package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.InterviewDTO;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;

public interface InterviewService {

    Interview getInterView(Integer id);

    Object add(InterviewDTO interviewDTO);


}
