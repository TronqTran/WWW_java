package vn.edu.iuh.lab_06.repositories;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_06.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByEmailAndPassword(String email, String password);
}
