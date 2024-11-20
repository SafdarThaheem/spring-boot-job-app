package GFM.jobApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private Long Id;
    private String title;
    private String description;
    private String jobType;
    private String location;
    private String maxSalary;
    private String minSalary;
}