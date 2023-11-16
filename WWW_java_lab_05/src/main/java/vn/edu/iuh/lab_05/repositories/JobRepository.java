package vn.edu.iuh.lab_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_05.models.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Override
    List<Job>findAll();
}
