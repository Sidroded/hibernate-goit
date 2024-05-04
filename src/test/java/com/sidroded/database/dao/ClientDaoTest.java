package com.sidroded.database.dao;

import com.sidroded.database.entity.Client;
import com.sidroded.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ClientDaoTest {
    private static SessionFactory sessionFactory;
    private static ClientDao clientDao;

    @BeforeAll
    public static void setUp() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        clientDao = new ClientDao();
    }

    @AfterAll
    public static void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testSaveClient() {
        Client client = new Client();
        client.setName("John Doe " + UUID.randomUUID());

        clientDao.save(client);

        assertNotNull(client.getId());
    }

    @Test
    public void testFindClientById() {
        Client client = new Client();
        client.setName("Jane Smith " + UUID.randomUUID());

        clientDao.save(client);

        Long id = client.getId();

        Client foundClient = clientDao.findById(id);

        assertNotNull(foundClient);
        assertEquals(client.getName(), foundClient.getName());
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client();
        client.setName("Alice Johnson " + UUID.randomUUID());

        clientDao.save(client);

        Long id = client.getId();

        Client updatedClient = new Client();
        updatedClient.setId(id);
        updatedClient.setName("Alice Johnson Updated " + UUID.randomUUID());

        clientDao.update(updatedClient);

        Client foundClient = clientDao.findById(id);

        assertNotNull(foundClient);
        assertEquals(updatedClient.getName(), foundClient.getName());
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client();
        client.setName("Bob Brown " + UUID.randomUUID());

        clientDao.save(client);

        Long id = client.getId();

        clientDao.delete(client);

        Client deletedClient = clientDao.findById(id);

        assertNull(deletedClient);
    }
}
