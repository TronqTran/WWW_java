package vn.edu.iuh.lab_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_05.models.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
