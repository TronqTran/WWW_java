package vn.edu.iuh.lab_02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.lab_02.configs.DatabaseConnection;
import vn.edu.iuh.lab_02.models.ProductImage;

public class ProductImageRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ProductImageRepository() {
        this.entityManager = DatabaseConnection.getInstance().getEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public void addProductImage(ProductImage productImage){
        try {
            entityTransaction.begin();
            entityManager.persist(productImage);
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }

    public void deleteProductImage(long id, long productId){
        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("ProductImage.DELETE");
            query.setParameter("id", id);
            query.setParameter("pId", productId);
            query.executeUpdate();
            entityTransaction.commit();
        }
        catch (Exception ex){
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }
}
