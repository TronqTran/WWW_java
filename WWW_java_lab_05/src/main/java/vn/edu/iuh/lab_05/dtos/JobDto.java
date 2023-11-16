package vn.edu.iuh.lab_05.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private String jobName;
    private String jobDescription;
    private List<JobSkillDto> jobSkillDtoList;

    @Override
    public String toString() {
        return "JobDto{" +
                "jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobSkillDtoList=" + jobSkillDtoList +
                '}';
    }
}
