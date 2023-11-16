package vn.edu.iuh.lab_05.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.lab_05.enums.SkillType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skill")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;
    @Column(name = "skill_name")
    private String skillName;
    @Column(name = "skill_desc")
    private String skillDescription;
    @Column(name = "skill_type")
    private SkillType type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "skill")
    @JsonIgnore
    private Set<JobSkill> jobSkills = new HashSet<>();

    public Skill(String skillName, String skillDescription, SkillType type) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.type = type;
    }

    public Skill(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                ", type=" + type +
                '}';
    }
}
