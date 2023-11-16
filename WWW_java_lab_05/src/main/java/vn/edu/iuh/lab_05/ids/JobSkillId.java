package vn.edu.iuh.lab_05.ids;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import vn.edu.iuh.lab_05.models.Job;
import vn.edu.iuh.lab_05.models.Skill;

import java.io.Serializable;
import java.util.Objects;

@Data
public class JobSkillId implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;

}
