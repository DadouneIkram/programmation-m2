package com.tp.dao;

import com.tp.entity.Info;
import javax.persistence.EntityManager;
import java.util.Collection;

public class InfoDaoImpl implements InfoDao {

    @Override
    public Long create(Info obj) {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return obj.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(long id) {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Info i = em.find(Info.class, id);
            if (i == null) {
                em.getTransaction().rollback();
                return false;
            }
            em.remove(i);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Collection<Info> getAll() {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            return em.createQuery("SELECT i FROM Info i", Info.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Info getByPk(long id) {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            return em.find(Info.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Info obj) {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}