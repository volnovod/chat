package com.chat.server.model;

import java.util.List;

/**
 * Created by victor on 15.11.15.
 */
public interface ClientService {

    void createClient(Client client);

    Client getClient(Integer id);

    boolean deleteClient(Client client);

    boolean updateClient(Client client);

    List<Client> getClientByLogin(String login);

    List<Client> getAllClients();
}
