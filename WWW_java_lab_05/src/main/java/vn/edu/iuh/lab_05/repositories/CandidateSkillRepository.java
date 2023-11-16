package vn.edu.iuh.lab_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_05.ids.CandidateSkillId;
import vn.edu.iuh.lab_05.models.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}