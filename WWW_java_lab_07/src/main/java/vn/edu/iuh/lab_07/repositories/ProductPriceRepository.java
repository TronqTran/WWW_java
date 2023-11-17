package vn.edu.iuh.lab_07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_07.models.ProductPrice;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
}
