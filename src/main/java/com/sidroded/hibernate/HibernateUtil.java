package com.sidroded.hibernate;

import com.sidroded.database.entity.Client;
import com.sidroded.database.entity.Planet;
import com.sidroded.database.entity.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        this.sessionFactory.close();
    }

}
