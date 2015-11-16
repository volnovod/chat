package com.chat.model;

import java.util.List;

/**
 * Created by victor on 15.11.15.
 */
public interface ChatDao {

    Integer create(Client client);

    Client read(Integer id);

    boolean update(Client client);

    boolean delete(Client client);

    List<Client> findAll();

}
