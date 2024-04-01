package com.sidroded.hibernate;

import com.sidroded.database.entity.Client;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilClient {
    private static final HibernateUtilClient INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtilClient();
    }

    private HibernateUtilClient() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
    }

    public static HibernateUtilClient getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}

