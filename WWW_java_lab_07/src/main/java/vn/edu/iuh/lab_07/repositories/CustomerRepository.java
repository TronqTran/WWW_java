package vn.edu.iuh.lab_07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_07.models.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findCustomerByEmailAndPassword(String email, String password);

    public Optional<Customer> findCustomerByEmail(String email);
}
