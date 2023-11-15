package vn.edu.iuh.lab_02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.lab_02.configs.DatabaseConnection;
import vn.edu.iuh.lab_02.models.ProductPrice;

public class ProductPriceRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ProductPriceRepository() {
        this.entityManager = DatabaseConnection.getInstance().getEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public void addProductPrice(ProductPrice productPrice){
        try {
            entityTransaction.begin();
            entityManager.persist(productPrice);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }
}
