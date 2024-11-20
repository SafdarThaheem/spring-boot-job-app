package GFM.jobApp.controllers;

import GFM.jobApp.models.Job;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create-job")
    public String createJob(@RequestBody Job job) {
        jobs.add(job);
        return "Job Created";
    }
}
