package com.ayhanekin.SpringAOP.repo;

import com.ayhanekin.SpringAOP.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {


    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);




}
