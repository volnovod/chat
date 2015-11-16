package com.chat.server.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by victor on 17.11.15.
 */
public class Test {

    public static void main(String[] args) {
        ClientService service = new ClassPathXmlApplicationContext("transactionalContext.xml")
                .getBean("clientService", ClientServiceImpl.class);
//        Client client = new Client();
//        client.setName("Victor");
//        client.setSecondName("Petrus");
//        client.setBirthDate(new Date(1992,12,3));
//        client.setLogin("victor");
//        client.setPassword("qwerty");
//        client.setPath("/var/petrus");
//        service.createClient(client);
        List<Client> clients = service.getClientByLogin("victor");

        System.out.println(clients.get(0).toString());

    }
}
