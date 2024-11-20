package GFM.jobApp.controllers;

import GFM.jobApp.models.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    private final List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return jobs;
    }
}
