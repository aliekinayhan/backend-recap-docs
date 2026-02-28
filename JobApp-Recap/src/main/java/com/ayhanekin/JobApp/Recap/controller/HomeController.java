package com.ayhanekin.JobApp.Recap.controller;


import com.ayhanekin.JobApp.Recap.model.JobPost;
import com.ayhanekin.JobApp.Recap.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    JobService service;

    @GetMapping("/")
    public String index() {
        System.out.println("Home Method 1 Has Been Called");
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("Home Method 2 Has Been Called");
        return "home";
    }


    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model) {

        System.out.println("View All Jobs Method Has Been Called");
        model.addAttribute("jobPosts",service.getAllJobs());
        return "viewalljobs";
    }

    @GetMapping("/addjob")
    public String addJob() {
        System.out.println("Add JobPost Method Has Been Called");
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) {
        System.out.println("Add JobPost Method Has Been Called");
        service.addJob(jobPost);
        return "success";
    }

}
