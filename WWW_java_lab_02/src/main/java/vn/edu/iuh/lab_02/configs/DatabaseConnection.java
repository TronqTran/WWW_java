package vn.edu.iuh.lab_02.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private EntityManager entityManager;

    private DatabaseConnection() {
        this.entityManager = Persistence.createEntityManagerFactory("week02").createEntityManager();
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
