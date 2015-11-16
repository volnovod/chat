package com.chat.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by victor on 15.11.15.
 */
@Repository("dao")
@Transactional
public class ChatDaoImpl implements ChatDao {

    @Autowired
    private SessionFactory factory;


    @Override
    public Integer create(Client client) {
        return (Integer)factory.getCurrentSession().save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client read(Integer id) {
        return (Client) factory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        factory.getCurrentSession().update("CLIENT", client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        factory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return factory.getCurrentSession().createCriteria(Client.class).list();
    }
}
