package com.sidroded.database.dao;

import com.sidroded.database.entity.Planet;
import com.sidroded.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetDaoTest {
    private static SessionFactory sessionFactory;
    private static PlanetDao planetDao;

    @BeforeAll
    public static void setUp() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        planetDao = new PlanetDao();
    }

    @AfterAll
    public static void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testSavePlanet() {
        Planet planet = new Planet();
        planet.setId(UUID.randomUUID().toString());
        planet.setName("Earth");

        planetDao.save(planet);

        assertNotNull(planet.getId());
    }

    @Test
    public void testFindPlanetById() {
        Planet planet = new Planet();
        String id = UUID.randomUUID().toString();
        planet.setId(id);
        planet.setName("Mars");

        planetDao.save(planet);

        Planet foundPlanet = planetDao.findById(id);

        assertNotNull(foundPlanet);
        assertEquals(planet.getName(), foundPlanet.getName());
    }

    @Test
    public void testUpdatePlanet() {
        Planet planet = new Planet();
        String id = UUID.randomUUID().toString();
        planet.setId(id);
        planet.setName("Jupiter");

        planetDao.save(planet);

        Planet updatedPlanet = new Planet();
        updatedPlanet.setId(id);
        updatedPlanet.setName("Jupiter Updated");

        planetDao.update(updatedPlanet);

        Planet foundPlanet = planetDao.findById(id);

        assertNotNull(foundPlanet);
        assertEquals(updatedPlanet.getName(), foundPlanet.getName());
    }

    @Test
    public void testDeletePlanet() {
        Planet planet = new Planet();
        String id = UUID.randomUUID().toString();
        planet.setId(id);
        planet.setName("Neptune");

        planetDao.save(planet);

        planetDao.delete(planet);

        Planet deletedPlanet = planetDao.findById(id);

        assertNull(deletedPlanet);
    }
}
