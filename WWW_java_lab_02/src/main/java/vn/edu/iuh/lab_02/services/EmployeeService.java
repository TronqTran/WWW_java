package vn.edu.iuh.lab_02.services;

import vn.edu.iuh.lab_02.enums.EmployeeStatus;
import vn.edu.iuh.lab_02.models.Employee;
import vn.edu.iuh.lab_02.models.Order;
import vn.edu.iuh.lab_02.repositories.EmployeeRepository;
import vn.edu.iuh.lab_02.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
        this.orderRepository = new OrderRepository();
    }

    public void addEmployee(Employee employee){
        employee.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.addEmployee(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.getAll();
    }

    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }

    public boolean updateEmployee(long id, Employee employee){
        Optional<Employee> rs = employeeRepository.findById(id);
        if (rs.isEmpty()) {
            return false;
        }
        Employee existingEmployee = rs.get();

        if(employee.getAddress() != null){
            existingEmployee.setAddress(employee.getAddress());
        }
        if(employee.getDob() != null){
            existingEmployee.setDob(employee.getDob());
        }
        if(employee.getEmail() != null){
            existingEmployee.setEmail(employee.getEmail());
        }
        if(employee.getPhone() != null){
            existingEmployee.setPhone(employee.getPhone());
        }
        if(employee.getFullName() != null){
            existingEmployee.setFullName(employee.getFullName());
        }
        if(employee.getStatus() != null){
            existingEmployee.setStatus(employee.getStatus());
        }
        employeeRepository.updateEmployee(existingEmployee);
        return true;
    }

    public boolean deleteEmployee(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            return false;
        }
        employeeRepository.deleteEmployee(id);
        return true;
    }

    public List<Order>getOrder(String date, String fromDate, String toDate, long empId){
        if(date != null){
            return orderRepository.statisticByDayByEmployee(date, empId);
        }
        if(fromDate != null && toDate != null){
            return orderRepository.statisicFromRangeByEmployee(fromDate, toDate, empId);
        }

        return orderRepository.statisticByEmployee(empId);
    }
}
