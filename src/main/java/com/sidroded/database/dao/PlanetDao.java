package com.sidroded.database.dao;

import com.sidroded.database.entity.Planet;
import com.sidroded.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(planet);
            tx.commit();
        }
    }
}
