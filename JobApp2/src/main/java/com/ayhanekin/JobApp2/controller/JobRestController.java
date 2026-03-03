package com.ayhanekin.JobApp2.controller;


import com.ayhanekin.JobApp2.model.JobPost;
import com.ayhanekin.JobApp2.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("/jobPost")
    public void addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
    }

    @PutMapping("/jobPost")
    public void updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
    }

    @DeleteMapping("/jobPost/{postId}")
    public void deleteJob (@PathVariable("postId") int postId) {
        service.deleteJob(postId);
    }

    @GetMapping("/load")
    public String load () {
        service.load();
        return "succes...";
    }

    @GetMapping("/jobPosts/{keyword}")
    public List<JobPost> searcByKeyword(@PathVariable String keyword) {
        return service.searchByKeyword(keyword);
    }

}
