package vn.edu.iuh.lab_05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.lab_05.enums.SkillLevel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"company"})
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long id;
    @Column(name = "job_name", length = 255, nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company")
    private Company company;
    @Column(name = "job_desc", length = 2000, nullable = false)
    private String description;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills = new ArrayList<>();

    public Job(String name, Company company, String description) {
        this.name = name;
        this.company = company;
        this.description = description;
    }

    public void addJobSKill(long skillId, SkillLevel skillLevel){
        Skill skill = new Skill(skillId);
        JobSkill jobSkill = new JobSkill(this, skill, "", skillLevel);
        this.jobSkills.add(jobSkill);
    }

}
