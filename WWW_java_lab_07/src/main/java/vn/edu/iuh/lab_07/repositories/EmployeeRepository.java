package vn.edu.iuh.lab_07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_07.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}