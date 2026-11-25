package com.tp.dao;

import com.tp.entity.Activite;
import javax.persistence.EntityManager;
import java.util.Collection;

public class ActiviteDaoImpl implements ActiviteDao {

    @Override
    public Long create(Activite obj) {
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
            Activite a = em.find(Activite.class, id);
            if (a == null) {
                em.getTransaction().rollback();
                return false;
            }
            em.remove(a);
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
    public Collection<Activite> getAll() {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Activite a", Activite.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Activite getByPk(long id) {
        EntityManager em = JpaUtil.getFactory().createEntityManager();
        try {
            return em.find(Activite.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Activite obj) {
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