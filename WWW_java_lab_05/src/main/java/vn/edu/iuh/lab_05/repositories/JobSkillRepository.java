package vn.edu.iuh.lab_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.lab_05.ids.JobSkillId;
import vn.edu.iuh.lab_05.models.JobSkill;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
}