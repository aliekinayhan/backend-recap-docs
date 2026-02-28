package com.ayhanekin.JobApp2.service;

import com.ayhanekin.JobApp2.model.JobPost;
import com.ayhanekin.JobApp2.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository repository;

    public void addJob(JobPost jobPost) {
        repository.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repository.findAll();
    }

    public JobPost getJob(int index) {
        return repository.findById(index).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repository.save(jobPost);
    }

    public void deleteJob(int postId) {
        repository.deleteById(postId);
    }

    public List<JobPost> searchByKeyword (String keyword) {
        return repository.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

    public void load() {
         List<JobPost> jobPosts = new ArrayList<>(List.of(

                new JobPost(1, "Java Developer",
                        "Backend development with Spring Boot",
                        2,
                        List.of("Java")),

                new JobPost(2, "Full Stack Developer",
                        "Backend + frontend development",
                        3,
                        List.of("Java", "React")),

                new JobPost(3, "Frontend Developer",
                        "Building UI applications",
                        1,
                        List.of("Angular")),

                new JobPost(4, "Python Developer",
                        "Automation and backend scripting",
                        2,
                        List.of("Python")),

                new JobPost(5, "Software Engineer",
                        "Designing scalable systems",
                        4,
                        List.of("Java", "Angular")),

                new JobPost(6, "Backend Engineer",
                        "REST API development",
                        3,
                        List.of("Java", "Python")),

                new JobPost(7, "Frontend Engineer",
                        "SPA applications and UI components",
                        2,
                        List.of("React")),

                new JobPost(8, "Full Stack Engineer",
                        "End-to-end feature development",
                        5,
                        List.of("Java", "React", "Angular")),

                new JobPost(9, "Python Backend Developer",
                        "Data processing services",
                        2,
                        List.of("Python", "Java")),

                new JobPost(10, "Web Developer",
                        "Modern web application development",
                        1,
                        List.of("React", "Angular"))
        ));
        repository.saveAll(jobPosts);
    }




}
