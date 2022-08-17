package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.InterviewDTO;
import com.example.BIWorld.Service.InterviewService;
import com.example.BIWorld.Service.InterviewServiceImp;
import com.example.BIWorld.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Interview")
public class InterviewController {

    private final InterviewService interviewServiceImp;

    public InterviewController(InterviewServiceImp interviewservice) {
        this.interviewServiceImp = interviewservice;
    }

    @GetMapping("/Show")
    public Interview getInterView(Integer id) {
        return interviewServiceImp.getInterView(id);
    }

    @PostMapping("/add")
    public Object register(@RequestBody InterviewDTO interviewDTO) {
        System.out.println("register Requiest " + interviewDTO.toString());
        Interview reinterview = interviewServiceImp.add(interviewDTO);
        if (reinterview != null) {
            return true;
        }
        return false;
    }


}
