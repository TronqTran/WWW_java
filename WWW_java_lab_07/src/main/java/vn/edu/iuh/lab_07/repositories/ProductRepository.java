package vn.edu.iuh.lab_07.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_07.enums.ProductStatus;
import vn.edu.iuh.lab_07.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product>findProductByStatusEquals(ProductStatus status, Pageable pageable);
}
