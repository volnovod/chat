package com.chat.server;

import com.chat.server.model.Client;
import com.chat.server.model.ClientService;
import com.chat.server.model.ClientServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by victor on 16.11.15.
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            boolean isLogin=false;
            serverSocket = new ServerSocket(61111);
            Socket socket = serverSocket.accept();
            ClientService service = new ClassPathXmlApplicationContext("transactionalContext.xml")
                .getBean("clientService", ClientServiceImpl.class);
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                PrintWriter writer = new PrintWriter(outputStream, true);
                Scanner in = new Scanner(inputStream);


                String login;
                String password;
                Server server = new Server();
                String line="";
                if (in.hasNextLine()){
                    line = in.nextLine();
                    if (line.equals("logging")){
                        while(!isLogin){
                            line = in.nextLine();
                            if (line.equals("l") && in.hasNextLine()){
                                login = in.nextLine();
                                if (in.hasNextLine() && (line=in.nextLine()).equals("p")){
                                    password = in.nextLine();
                                    if (service.getClientByLogin(login).size()!=0 &&
                                            server.clientAuthentificator(login, password, service.getClientByLogin(login).get(0))){
                                        System.out.println("Login successful");
                                        writer.println("Login successful");
                                        isLogin=true;
                                    } else {
                                        System.out.println("Login error");
                                        writer.println("Login error");
                                    }
                                }
                        }
                    }
                }

                while(in.hasNextLine()){


                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public boolean clientAuthentificator(String login, String password, Client client){
        if (client.getLogin().equals(login) && client.getPassword().equals(password)){
            return true;
        } else{
            return false;
        }

    }
}
