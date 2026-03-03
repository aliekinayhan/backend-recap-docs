package com.ayhanekin.JobApp2.repository;

import com.ayhanekin.JobApp2.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {


    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);




}




















//private List<JobPost> jobPosts = new ArrayList<>(List.of(
//
//        new JobPost(1, "Java Developer",
//                "Backend development with Spring Boot",
//                2,
//                List.of("Java")),
//
//        new JobPost(2, "Full Stack Developer",
//                "Backend + frontend development",
//                3,
//                List.of("Java", "React")),
//
//        new JobPost(3, "Frontend Developer",
//                "Building UI applications",
//                1,
//                List.of("Angular")),
//
//        new JobPost(4, "Python Developer",
//                "Automation and backend scripting",
//                2,
//                List.of("Python")),
//
//        new JobPost(5, "Software Engineer",
//                "Designing scalable systems",
//                4,
//                List.of("Java", "Angular")),
//
//        new JobPost(6, "Backend Engineer",
//                "REST API development",
//                3,
//                List.of("Java", "Python")),
//
//        new JobPost(7, "Frontend Engineer",
//                "SPA applications and UI components",
//                2,
//                List.of("React")),
//
//        new JobPost(8, "Full Stack Engineer",
//                "End-to-end feature development",
//                5,
//                List.of("Java", "React", "Angular")),
//
//        new JobPost(9, "Python Backend Developer",
//                "Data processing services",
//                2,
//                List.of("Python", "Java")),
//
//        new JobPost(10, "Web Developer",
//                "Modern web application development",
//                1,
//                List.of("React", "Angular"))
//));
//
//public void saveJob (JobPost jobPost) {
//    jobPosts.add(jobPost);
//}
//
//public List<JobPost> getAllJobs () {
//    return jobPosts;
//}
//
//public JobPost getJob(int index) {
//    for (JobPost jobPost : jobPosts){
//        if (jobPost.getPostId() == index) {
//            return jobPost ;
//        }
//    }
//    return null;
//}
//
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost jobPost1 : jobPosts){
//        if (jobPost1.getPostId() == jobPost.getPostId()) {
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob (int postId) {
//    JobPost jobPost = new JobPost();
//    jobPost = getJob(postId);
//    jobPosts.remove(jobPost);
//}