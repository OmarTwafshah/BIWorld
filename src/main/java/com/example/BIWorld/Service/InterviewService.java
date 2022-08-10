package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.InterViewRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Interview;
import com.example.BIWorld.models.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InterviewService {
    private final InterViewRepository interViewRepository;

    @Autowired
    public InterviewService(InterViewRepository interViewRepository) {
        this.interViewRepository = interViewRepository;
    }

    public Interview getInterView(Integer id){
        return interViewRepository.findByInterview_id(id);
    }


    public Interview add(ApplyToJob applyToJob,
                    String date,
                    String location,
                    String employee_name,
                    String description){

        if(
//                applyToJob==null ||
                        date==null || location==null
                        || employee_name== null || description==null){
            return null;

        }else{
            Interview interview=new Interview();
            //interview.setApplyToJob(applyToJob);
            interview.setDate(LocalDate.parse(date));
            interview.setLocation(location);
            interview.setEmployee_name(employee_name);
            interview.setDescription(description);
            interViewRepository.save(interview);
            //applyToJob.setInterview(interview1);
            return interview ;

        }

    }
}
