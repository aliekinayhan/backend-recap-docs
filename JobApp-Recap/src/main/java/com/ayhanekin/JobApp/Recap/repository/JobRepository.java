package com.ayhanekin.JobApp.Recap.repository;

import com.ayhanekin.JobApp.Recap.model.JobPost;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Repository
public class JobRepository {

    private List<JobPost> jobPosts = new ArrayList<>();

    public void addJob (JobPost jobPost) {
        jobPosts.add(jobPost);
    }

    public List<JobPost> getAllJobs () {
        return jobPosts;
    }

}
