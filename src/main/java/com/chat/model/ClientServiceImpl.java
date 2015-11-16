package com.chat.model;

/**
 * Created by victor on 15.11.15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ChatDao dao;
    @Override
    public void createClient(Client client) {
        dao.create(client);
    }

    @Override
    public Client getClient(Integer id) {
        return dao.read(id);
    }

    @Override
    public boolean deleteClient(Client client) {
        return dao.delete(client);
    }

    @Override
    public boolean updateClient(Client client) {
        return dao.update(client);
    }

    @Override
    public List<Client> getAllClients() {
        return dao.findAll();
    }
}
