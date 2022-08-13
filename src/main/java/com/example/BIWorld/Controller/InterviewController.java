package com.example.BIWorld.Controller;

import com.example.BIWorld.Service.InterviewService;
import com.example.BIWorld.Service.InterviewServiceImp;
import com.example.BIWorld.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewController {

    private final InterviewService interviewServiceImp;

    public InterviewController(InterviewServiceImp interviewservice) {
        this.interviewServiceImp = interviewservice;
    }

    @GetMapping("/getMyInterView")
    public Interview getInterView(Integer id) {
        return interviewServiceImp.getInterView(id);
    }

    @PostMapping("/addInterview")
    public String register(@ModelAttribute Interview interview) {
        System.out.println("register Requiest" + interview);
        Interview reinterview = interviewServiceImp.add(
                interview.getApplyToJob(),
                String.valueOf(interview.getDate()),
                interview.getLocation(),
                interview.getEmployee_name(),
                interview.getDescription());
        if (reinterview != null) {
            System.out.println("Doneeeeeeeeee");
        }
        return reinterview == null ? "error" : "done";
    }


}
