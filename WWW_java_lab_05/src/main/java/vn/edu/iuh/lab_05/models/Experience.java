package vn.edu.iuh.lab_05.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"candidate"})
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "to_date")
    private LocalDate toDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "company", length = 120, nullable = false)
    private String companyName;
    @Column(name = "role", length = 100, nullable = false)
    private String role;
    @Column(name = "work_desc", length = 400, nullable = false)
    private String workDescription;

    public Experience(LocalDate toDate, Candidate candidate, LocalDate fromDate, String companyName, String role, String workDescription) {
        this.toDate = toDate;
        this.candidate = candidate;
        this.fromDate = fromDate;
        this.companyName = companyName;
        this.role = role;
        this.workDescription = workDescription;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", toDate=" + toDate +
                ", candidate=" + candidate.getId() +
                ", fromDate=" + fromDate +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", workDescription='" + workDescription + '\'' +
                '}';
    }
}
