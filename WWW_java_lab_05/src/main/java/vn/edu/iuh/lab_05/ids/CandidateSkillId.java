package vn.edu.iuh.lab_05.ids;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import vn.edu.iuh.lab_05.models.Candidate;
import vn.edu.iuh.lab_05.models.Skill;

import java.io.Serializable;

@Data
public class CandidateSkillId implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
}