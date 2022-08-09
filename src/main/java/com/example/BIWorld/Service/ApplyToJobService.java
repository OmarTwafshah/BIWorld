package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.ApplyToJob;
import com.example.BIWorld.models.Company;
import com.example.BIWorld.models.Jobs;
import com.example.BIWorld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ApplyToJobService {
    public final applyToJobRepository applyToJobRepository;
 @Autowired
    public ApplyToJobService(com.example.BIWorld.Repository.applyToJobRepository applyToJobRepository) {
        this.applyToJobRepository = applyToJobRepository;
    }
    public ApplyToJob ApplyJob(Set<Person> persons,
                               Company company,
                               Jobs jobs_To_application,
                               String date_of_application,
                               String status){
        if(persons==null || company == null || jobs_To_application == null || date_of_application == null || status == null){
            return null;
        }else{
            ApplyToJob apply=new ApplyToJob();
            apply.setPersons(persons);
            apply.setCompany(company);
            apply.setJobs_To_application(jobs_To_application);
            apply.setDate_of_application(LocalDate.parse(date_of_application));
            apply.setStatus(status);
             return applyToJobRepository.save(apply);

        }
    }

    public boolean DeleteApp(int appId) {
        Boolean exist=applyToJobRepository.existsById(appId);
        if(!exist){
            System.out.println("job does not exist");
            return false ;
        }
        applyToJobRepository.deleteById(appId);
        return true;
    }
}
