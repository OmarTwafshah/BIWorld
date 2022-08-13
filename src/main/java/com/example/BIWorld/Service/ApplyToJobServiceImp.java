package com.example.BIWorld.Service;

import com.example.BIWorld.Repository.PersonRepository;
import com.example.BIWorld.Repository.applyToJobRepository;
import com.example.BIWorld.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ApplyToJobServiceImp implements ApplyToJobService {
    public final applyToJobRepository applyToJobRepository;

    public final PersonRepository personRepository;

    public ApplyToJobServiceImp(com.example.BIWorld.Repository.applyToJobRepository applyToJobRepository, PersonRepository personRepository) {
        this.applyToJobRepository = applyToJobRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ApplyToJob addJobs(Set<Person> persons, Company company, Jobs jobs_to_application, String status) {
        if (persons == null
                || company == null
                || jobs_to_application == null
                || status == null) {
            return null;
        } else {

            ApplyToJob applyToJob = new ApplyToJob();
            //applyToJob.setPersons(persons);
            applyToJob.setCompany(company);
            applyToJob.setJobs_To_application(jobs_to_application);
            LocalDate currentDateTime = LocalDate.now();
            applyToJob.setDate_of_application(currentDateTime);
            applyToJob.setStatus(status);

            ApplyToJob applyToJob1 = applyToJobRepository.save(applyToJob);
            Set<ApplyToJob> applyToJobs = new HashSet<>();
            applyToJobs.add(applyToJob1);
            for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
                Person f = it.next();
                if (!personRepository.findById(f.getPersonID()).isEmpty()) {
                    f.setApplyToJobs(applyToJobs);
                    personRepository.save(f);
                } else {
                    System.out.println(f.getPersonID() + " is not found ");
                }

            }
            return applyToJob;
        }


    }

    @Override
    public boolean DeleteApp(int appId) {
        Boolean exist = applyToJobRepository.existsById(appId);
        if (!exist) {
            System.out.println("job does not exist");
            return false;
        }
        applyToJobRepository.deleteById(appId);
        return true;
    }

    @Override
    public List<ApplyToJob> getApplyJobs() {
        return applyToJobRepository.findAll();
    }
}
