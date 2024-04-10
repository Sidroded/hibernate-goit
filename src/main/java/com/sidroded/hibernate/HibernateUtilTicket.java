package com.sidroded.hibernate;

import com.sidroded.database.entity.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilTicket {
    private static final HibernateUtilTicket INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtilTicket();
    }

    private HibernateUtilTicket() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtilTicket getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}