package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.InterviewDTO;
import com.example.BIWorld.Repository.InterViewRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Interview;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class InterviewServiceImp implements InterviewService {
    private final InterViewRepository interViewRepository;

    private final applyToJobRepository ApplyToJobRepository;


    public InterviewServiceImp(InterViewRepository interViewRepository, applyToJobRepository applyToJobRepository) {
        this.interViewRepository = interViewRepository;
        ApplyToJobRepository = applyToJobRepository;
    }

    @Override
    public Interview getInterView(Integer id) {
        return interViewRepository.findByInterview_id(id);
    }


    @Override
    public Interview add(InterviewDTO interviewDTO) {

        if (interviewDTO.getApplyToJob() == null ||
                interviewDTO.getDate() == null || interviewDTO.getLocation() == null
                || interviewDTO.getEmployeeName() == null || interviewDTO.getDescription() == null) {
            return null;

        } else {
            Interview interview = new Interview();
            ApplyToJob applyToJob = ApplyToJobRepository.findByApplication_id(Integer.parseInt(interviewDTO.getApplyToJob()));
            interview.setApplyToJob(applyToJob);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate =  LocalDate.parse(interviewDTO.getDate(), format);
            interview.setDate(localDate);
            interview.setLocation(interviewDTO.getLocation());
            interview.setEmployee_name(interviewDTO.getEmployeeName());
            interview.setDescription(interviewDTO.getDescription());
            return interViewRepository.save(interview);
        }

    }
}
