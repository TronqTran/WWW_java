package vn.edu.iuh.lab_07.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_07.models.Customer;
import vn.edu.iuh.lab_07.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void insert(Customer customer){
        customerRepository.save(customer);
    }
    public List<Customer> findAll(){return customerRepository.findAll();}

    public Optional<Customer> login(String email, String password){
        return customerRepository.findCustomerByEmailAndPassword(email, password);
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }
}
