package com.ayhanekin.JobApp.Recap.service;

import com.ayhanekin.JobApp.Recap.model.JobPost;
import com.ayhanekin.JobApp.Recap.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository repository;

    public void addJob (JobPost jobPost) {
        repository.addJob(jobPost);
    }

    public List<JobPost> getAllJobs () {
         return repository.getAllJobs();
    }
}
