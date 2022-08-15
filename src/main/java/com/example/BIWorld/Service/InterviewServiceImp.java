package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.InterViewRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class InterviewServiceImp implements InterviewService {
    private final InterViewRepository interViewRepository;

    public InterviewServiceImp(InterViewRepository interViewRepository) {
        this.interViewRepository = interViewRepository;
    }

    @Override
    public Interview getInterView(Integer id){
        return interViewRepository.findByInterview_id(id);
    }


    @Override
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
            interview.setDate(LocalDateTime.parse(date));
            interview.setLocation(location);
            interview.setEmployee_name(employee_name);
            interview.setDescription(description);
            interViewRepository.save(interview);
            //applyToJob.setInterview(interview1);
            return interview ;

        }

    }
}
