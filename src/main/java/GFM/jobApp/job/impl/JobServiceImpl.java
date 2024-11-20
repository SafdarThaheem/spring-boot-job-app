package GFM.jobApp.job.impl;

import GFM.jobApp.job.JobService;
import GFM.jobApp.job.models.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
