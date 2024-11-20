package GFM.jobApp.job.controllers;

import GFM.jobApp.job.JobService;
import GFM.jobApp.job.models.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return jobService.findJobs();
    }

    @PostMapping("/create-job")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job Created";
    }
}
