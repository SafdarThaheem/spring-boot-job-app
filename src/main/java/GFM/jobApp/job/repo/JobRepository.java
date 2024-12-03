package GFM.jobApp.job.repo;

import GFM.jobApp.job.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
