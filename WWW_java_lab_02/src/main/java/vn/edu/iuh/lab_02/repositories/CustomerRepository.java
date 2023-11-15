package vn.edu.iuh.lab_02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.lab_02.configs.DatabaseConnection;
import vn.edu.iuh.lab_02.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public CustomerRepository() {
        this.entityManager = DatabaseConnection.getInstance().getEntityManager();
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void addCustomer(Customer customer){
        try {
            entityTransaction.begin();
            entityManager.persist(customer);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }

    }
    public List<Customer> getAll(){
        List<Customer> customers = entityManager.createNamedQuery("Customer.FIND_ALL").getResultList();
        return customers;
    }

    public Optional<Customer> findById(long id){
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    public void updateCustomer(Customer customer){
        try {
            entityTransaction.begin();
            entityManager.merge(customer);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }
}
