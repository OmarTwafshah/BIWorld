package com.example.BIWorld.Service;

import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;

public interface InterviewService {

    Interview getInterView(Integer id);

    Interview add(ApplyToJob applyToJob,
                  String date,
                  String location,
                  String employee_name,
                  String description);


}
