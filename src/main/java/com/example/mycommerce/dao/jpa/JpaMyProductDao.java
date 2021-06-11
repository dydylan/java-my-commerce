package com.example.mycommerce.dao.jpa;

import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaMyProductDao implements MyProductDao {

    private final EntityManagerFactory emf;

    public JpaMyProductDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public boolean create(MyProduct product) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(product);
            et.commit();
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public void update(MyProduct product) {
        // TODO
    }

    @Override
    public MyProduct findProductById(Long id) {
        // TODO
        return null;
    }

    @Override
    public List<MyProduct> getAllProducts() {
        // TODO
        return null;
    }

    @Override
    public void remove(MyProduct product) {
        // TODO
    }

    @Override
    public void removeProduct(Long id) {
        // TODO
    }

    @Override
    public void addProduct(MyProduct product) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(product);
            et.commit();
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}