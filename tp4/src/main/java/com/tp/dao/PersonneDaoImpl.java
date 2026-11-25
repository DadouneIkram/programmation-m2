package com.tp.dao;

import com.tp.entity.Personne;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class PersonneDaoImpl implements PersonneDao {

  @Override
  public Long create(Personne p) {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(p);
      em.getTransaction().commit();
      return p.getId();
    } catch (Exception e) {
      if (em.getTransaction().isActive())
        em.getTransaction().rollback();
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
      Personne p = em.find(Personne.class, id);
      if (p == null) {
        em.getTransaction().rollback();
        return false;
      }
      em.remove(p);
      em.getTransaction().commit();
      return true;
    } catch (Exception e) {
      if (em.getTransaction().isActive())
        em.getTransaction().rollback();
      e.printStackTrace();
      return false;
    } finally {
      em.close();
    }
  }

  @Override
  public Collection<Personne> getAll() {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public Personne getByPk(long id) {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      return em.find(Personne.class, id);
    } finally {
      em.close();
    }
  }

  @Override
  public boolean update(Personne p) {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      em.getTransaction().begin();
      em.merge(p);
      em.getTransaction().commit();
      return true;
    } catch (Exception e) {
      if (em.getTransaction().isActive())
        em.getTransaction().rollback();
      e.printStackTrace();
      return false;
    } finally {
      em.close();
    }
  }

  @Override
  public List<Personne> findByNom(String nom) {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      return em.createQuery("SELECT p FROM Personne p WHERE p.nom = :nom", Personne.class)
          .setParameter("nom", nom)
          .getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public List<Personne> trouveTout() {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public Personne findById(long id) {
    EntityManager em = JpaUtil.getFactory().createEntityManager();
    try {
      return em.find(Personne.class, id);
    } finally {
      em.close();
    }
  }
}