package vn.edu.iuh.lab_05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.lab_05.enums.SkillLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidate")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String phone;
    private LocalDate dob;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Experience>experiences = new ArrayList<>();

    public Candidate(String phone, LocalDate dob, String email, String fullName, Address address) {
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
    }

    public Candidate(long id) {
        this.id = id;
    }

    public void addCandidateSkill(long skillId, SkillLevel skillLevel){
        CandidateSkill candidateSkill = new CandidateSkill(new Skill(skillId), this, "", skillLevel);
        this.candidateSkills.add(candidateSkill);
    }

    public void addCandidateExperience(String companyName, String role, String workDescription, String fromDate, String toDate){
        Experience experience = new Experience(LocalDate.parse(toDate), this, LocalDate.parse(fromDate), companyName, role, workDescription);
        this.experiences.add(experience);
    }
    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                ", candidateSkills=" + candidateSkills +
                ", experiences=" + experiences +
                '}';
    }
}
