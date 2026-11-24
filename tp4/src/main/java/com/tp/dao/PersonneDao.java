package com.tp.dao;

import com.tp.entity.Personne;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonneDao {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("persistence_sql");

    public void sauve(Personne p) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}