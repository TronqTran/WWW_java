package vn.edu.iuh.lab_05.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_05.models.Job;
import vn.edu.iuh.lab_05.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    private JobRepository jobRepository;
    @Autowired

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAll(){
        return jobRepository.findAll();
    }


    public Job addJob(Job job){
        Job savedJob = jobRepository.saveAndFlush(job);
        return savedJob;
    }
}
