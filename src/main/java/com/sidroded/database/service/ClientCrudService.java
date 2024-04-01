package com.sidroded.database.service;

import com.sidroded.database.dao.ClientDao;
import com.sidroded.database.entity.Client;

public class ClientCrudService {
    private final ClientDao clientDao = new ClientDao();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
