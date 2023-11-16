package vn.edu.iuh.lab_05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.lab_05.enums.SkillLevel;
import vn.edu.iuh.lab_05.ids.CandidateSkillId;

@Entity
@Table(name = "candidate_skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CandidateSkillId.class)
public class CandidateSkill {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "more_info", length = 1000)
    private String moreInfo;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "skill=" + skill.getId() +
                ", candidate=" + candidate.getId() +
                ", moreInfo='" + moreInfo + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
