package vn.edu.iuh.lab_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_05.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
