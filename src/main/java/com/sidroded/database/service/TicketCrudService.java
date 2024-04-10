package com.sidroded.database.service;

import com.sidroded.database.dao.TicketDao;
import com.sidroded.database.entity.Ticket;

public class TicketCrudService {
    private final TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
