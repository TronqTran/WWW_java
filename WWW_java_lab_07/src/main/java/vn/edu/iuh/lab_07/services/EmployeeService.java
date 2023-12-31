package vn.edu.iuh.lab_07.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_07.models.Employee;
import vn.edu.iuh.lab_07.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findAll(int page, int limit){
        return employeeRepository.findAll(PageRequest.of(page - 1, limit));
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee>findById(long id){
        return employeeRepository.findById(id);
    }
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void remove(long id){
        employeeRepository.deleteById(id);
    }

}
