package com.sidroded.hibernate;

import com.sidroded.database.entity.Planet;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilPlanet {
    private static final HibernateUtilPlanet INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtilPlanet();
    }

    private HibernateUtilPlanet() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtilPlanet getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}