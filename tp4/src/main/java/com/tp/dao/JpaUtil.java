package com.tp.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("persistence_sql");

    public static EntityManagerFactory getFactory() {
        return FACTORY;
    }
}