package com.sidroded.database.dao;

import com.sidroded.database.entity.Client;
import com.sidroded.database.entity.Planet;
import com.sidroded.database.entity.Ticket;
import com.sidroded.database.service.ClientCrudService;
import com.sidroded.database.service.PlanetCrudService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TicketDaoTest {
    private final TicketDao ticketDao = new TicketDao();
    private Ticket testTicket;
    private Client testClient = new Client();
    private Planet testFromPlanet = new Planet("TESTFROM", "TESTFROM");
    private Planet testToPlanet = new Planet("TESTTO", "TESTTO");

    @BeforeEach
    void setUp() {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();


        testClient.setName("Test Client" + UUID.randomUUID());
        testFromPlanet = new Planet("TESTFROM", "TESTFROM");
        testToPlanet = new Planet("TESTTO", "TESTTO");

        clientCrudService.saveClient(testClient);
        planetCrudService.savePlanet(testToPlanet);
        planetCrudService.savePlanet(testFromPlanet);

        testTicket = new Ticket();
        testTicket.setCreatedAt(LocalDateTime.now());
        testTicket.setClient(testClient);
        testTicket.setFromPlanet(testFromPlanet);
        testTicket.setToPlanet(testToPlanet);
        ticketDao.save(testTicket);
    }

    @AfterEach
    void tearDown() {
        if (testTicket != null && testTicket.getId() != null) {
            ticketDao.delete(testTicket);
        }

        PlanetCrudService planetCrudService = new PlanetCrudService();
        planetCrudService.deletePlanet(testFromPlanet);
        planetCrudService.deletePlanet(testToPlanet);
    }

    @Test
    void testSaveTicket() {
        assertNotNull(testTicket.getId(), "Ticket ID should not be null after saving");
    }

    @Test
    void testFindTicketById() {
        Ticket foundTicket = ticketDao.findById(testTicket.getId());
        assertNotNull(foundTicket, "Found ticket should not be null");
        assertEquals(testTicket.getId(), foundTicket.getId(), "Found ticket ID should match");
    }

    @Test
    void testUpdateTicket() {
        testClient.setName("NEW NAME");
        testTicket.setClient(testClient);
        ticketDao.update(testTicket);
        Ticket updatedTicket = ticketDao.findById(testTicket.getId());
        assertEquals(updatedTicket.getClient().getName(), testTicket.getClient().getName());
    }

    @Test
    void testDeleteTicket() {
        ticketDao.delete(testTicket);
        Ticket deletedTicket = ticketDao.findById(testTicket.getId());
        assertNull(deletedTicket, "Deleted ticket should be null");
    }
}
