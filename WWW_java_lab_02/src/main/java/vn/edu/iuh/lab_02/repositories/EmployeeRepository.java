package vn.edu.iuh.lab_02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.lab_02.configs.DatabaseConnection;
import vn.edu.iuh.lab_02.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public EmployeeRepository() {
        this.entityManager = DatabaseConnection.getInstance().getEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public void addEmployee(Employee employee){
        try {
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }

    public List<Employee> getAll(){
        return entityManager.createNamedQuery("Employee.FIND_ALL").getResultList();
    }

    public Optional<Employee> findById(long id){
        Query query = entityManager.createNamedQuery("Employee.FIND_BY_ID");
        query.setParameter("empId", id);
        List<Employee> employees = query.getResultList();
        if(employees.size() == 0){
            return Optional.empty();
        }

        return Optional.of(employees.get(0));
    }

    public void updateEmployee(Employee employee){
        try {
            entityTransaction.begin();
            entityManager.merge(employee);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }

    public void deleteEmployee(long id){
        try {
            entityTransaction.begin();

            Query query = entityManager.createNamedQuery("Employee.DELETE");
            query.setParameter("empId", id);
            query.executeUpdate();

            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }

    }
}