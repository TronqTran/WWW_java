package vn.edu.iuh.lab_07.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_07.models.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Page<Order>findOrdersByCustomerIdAndEmployeeIdAndOrderDateBetween(long cusId, long empId, LocalDateTime startDate, LocalDateTime endDate, Pageable page);
    public Page<Order>findOrdersByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable page);

    public Page<Order>findOrdersByCustomerIdAndOrderDateBetween(long cusId, LocalDateTime startDate, LocalDateTime endDate, Pageable page);

    public Page<Order>findOrdersByEmployeeIdAndOrderDateBetween(long empId, LocalDateTime startDate, LocalDateTime endDate, Pageable page);

}
