package com.ayhanekin.SpringDataRestDemo.repo;

import com.ayhanekin.SpringDataRestDemo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import java.util.List;

@RepositoryRestController
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {


    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);




}